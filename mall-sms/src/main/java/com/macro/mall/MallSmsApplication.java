package com.macro.mall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
@SpringBootApplication
@EnableDubbo
@EnableCaching
public class MallSmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallSmsApplication.class, args);
    }
}
