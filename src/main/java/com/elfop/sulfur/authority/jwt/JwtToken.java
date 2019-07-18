package com.elfop.sulfur.authority.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.elfop.sulfur.base.common.Dic.TOKEN_EFFECTIVE_TIME;

/**
 * @Description: token服务
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/17  15:23
 */
@Component
public class JwtToken implements Serializable, Token {

    @Value("${token.expiration}")
    private Long expirationTime;

    @Value("${token.secret}")
    private String secret;


    /**
     * 生成token
     *
     * @param userId 用户id
     * @param claims 自定义 key-value 参数集
     * @return
     */
    @Override
    public String generate(String userId, Map<String, Object> claims) {
        return Jwts.builder()
                .setAudience(userId)
                .setNotBefore(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * TOKEN_EFFECTIVE_TIME))
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public String generate(String userId) {
        return generate(userId, new HashMap<>(0));
    }

    /**
     * 验证token
     *
     * @param token
     */
    @Override
    public void verify(String token) {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }

    /**
     * token 是否过期
     *
     * @param token
     * @return
     */
    @Override
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 根据token 获取过期时间
     *
     * @param token
     * @return
     */
    @Override
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    /**
     * 根据token获取id
     *
     * @param token
     * @return
     */
    @Override
    public String getUserId(String token) {
        final Claims claims = getClaimsFromToken(token);
        return claims.getAudience();
    }

    /***
     * 解析token 信息
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    //签名的key
                    .setSigningKey(secret)
                    // 签名token
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 根据token 获得存放在Claims中的数据
     *
     * @param token
     * @param key
     * @return
     */
    @Override
    public Object tokenClaims(String token, String key) {
        return getClaimsFromToken(token).get(key);
    }

    /**
     * 刷新重新获取token
     *
     * @param token 源token
     * @return
     */
    @Override
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            refreshedToken = generate(claims.getSubject(), claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

}
