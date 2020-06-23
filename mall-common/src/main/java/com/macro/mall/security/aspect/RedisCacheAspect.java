package com.macro.mall.security.aspect;

import cn.hutool.core.util.HashUtil;
import com.alibaba.fastjson.JSON;
import com.macro.mall.security.annotation.CacheException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Redis缓存切面，防止Redis宕机影响正常业务逻辑
 * Created by macro on 2020/3/17.
 */
@Aspect
@Component
@Order(2)
public class RedisCacheAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(RedisCacheAspect.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("execution(public * com.macro.mall.portal.service.*CacheService.*(..)) || execution(public * com.macro.mall.service.*CacheService.*(..))")
    public void cacheAspect() {
    }

    @Around("cacheAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            //有CacheException注解的方法需要抛出异常
            if (method.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            } else {
                LOGGER.error(throwable.getMessage());
            }
        }
        return result;
    }

    @Pointcut("execution(public * com.macro.mall.service.*Service.get*(..)) " +
            "|| execution(public * com.macro.mall.service.*Service.find*(..)) "+
            "|| execution(public * com.macro.mall.service.*Service.list*(..))")
    public void cachableAspect() {
    }

    @Around("cachableAspect()")
    public Object cachableAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String key=buildKey(joinPoint);
        Object result = null;
        try {
            if(redisTemplate.hasKey(key)){
                return redisTemplate.opsForValue().get(key);
            }
            result = joinPoint.proceed();
            redisTemplate.opsForValue().set(key, result);
        } catch (Throwable throwable) {
            //有CacheException注解的方法需要抛出异常
            if (method.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            } else {
                LOGGER.error(throwable.getMessage());
            }
        }
        return result;
    }
    @Pointcut("execution(public * com.macro.mall.service.*Service.add*(..)) " +
            "|| execution(public * com.macro.mall.service.*Service.insert*(..))" +
            "|| execution(public * com.macro.mall.service.*Service.create*(..))" +
            "|| execution(public * com.macro.mall.service.*Service.update*(..))" +
            "|| execution(public * com.macro.mall.service.*Service.delete*(..))")
    public void cacheEvictAspect() {
    }

    @Around("cacheEvictAspect()")
    public Object cacheEvictAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method[] methods = signature.getDeclaringType().getDeclaredMethods();
        Method jMethod = methodSignature.getMethod();
        String clazzName=signature.getDeclaringTypeName();
        Object result = null;
        try {
            result = joinPoint.proceed();
            for(Method method:methods){
                if(method.getName().matches("get*")
                        || method.getName().matches("list*")
                        || method.getName().matches("find*")){
                    try{
                        redisTemplate.delete(redisTemplate.keys(clazzName+"-"+method.getName()+"-*"));
                    }catch (Exception e){
                        LOGGER.error("Error: ",e);
                    }
                }
            }
        } catch (Throwable throwable) {
            //有CacheException注解的方法需要抛出异常
            if (jMethod.isAnnotationPresent(CacheException.class)) {
                throw throwable;
            } else {
                LOGGER.error(throwable.getMessage());
            }
        }
        return result;
    }

    private String getKeyPrefix(ProceedingJoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String clazzName=signature.getDeclaringTypeName();
        String methodName= method.getName();
        return clazzName+"-"+methodName;
    }
    private String buildKey(ProceedingJoinPoint joinPoint){
        String argValue="";
        Object[] args = joinPoint.getArgs();
        for(Object o:args){
            if(o==null){
                argValue+="-null";
                continue;
            }
            if("java.lang".equals(o.getClass().getPackage().getName())){
                argValue+="-"+String.valueOf(o);
            }else{
                argValue+="-"+HashUtil.rsHash(JSON.toJSONString(o));
            }
        }
        return getKeyPrefix(joinPoint)+argValue;
    }
}
