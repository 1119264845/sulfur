package com.elfop.sulfur.authority.jwt;

import java.util.Date;
import java.util.Map;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2019/7/18  9:28
 */
public interface Token {

    /**
     * 生成token
     *
     * @param userId 用户id
     * @param claims 自定义 key-value 参数集
     * @return
     */
    String generate(String userId, Map<String, Object> claims);

    /**
     * 生成token
     *
     * @param userId 用户id
     * @return
     */
    String generate(String userId);

    /**
     * 验证token
     *
     * @param token
     */
    void verify(String token);

    /**
     * token 是否过期
     *
     * @param token
     * @return
     */
    Boolean isTokenExpired(String token);

    /**
     * 根据token 获取过期时间
     *
     * @param token
     * @return
     */
    Date getExpirationDateFromToken(String token);

    /**
     * 根据token获取id
     *
     * @param token
     * @return
     */
    String getUserId(String token);

    /**
     * 根据token 获得存放在Claims中的数据
     *
     * @param token
     * @param key
     * @return
     */
    Object tokenClaims(String token, String key);

    /**
     * 刷新重新获取token
     *
     * @param token 源token
     * @return
     */
    String refreshToken(String token);


}
