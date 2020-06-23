package com.macro.mall.security.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * JwtToken生成的工具类
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）：
 * {"alg": "HS512","typ": "JWT"}
 * payload的格式（用户名、创建时间、生成时间）：
 * {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 * Created by macro on 2018/4/26.
 */
public interface JwtTokenService {
    /**
     * 从token中获取登录用户名
     */
    String getUserNameFromToken(String token);

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    boolean validateToken(String token, UserDetails userDetails);
    /**
     * 根据用户信息生成token
     */
    String generateToken(UserDetails userDetails);

    /**
     * 当原来的token没过期时是可以刷新的
     *
     * @param oldToken 带tokenHead的token
     */
    String refreshHeadToken(String oldToken);
}
