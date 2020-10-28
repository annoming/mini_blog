package com.atming.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Annoming
 * @Date: 2020/10/28
 * @Time: 21:29
 * @Description
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "mini.jwt")
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;


    /**
     * 生成jwt token
     * @param userId 用户id
     * @return String
     */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(userId + "")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * token是否过期
     * @param expiration 过期时间
     * @return boolean
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

}
