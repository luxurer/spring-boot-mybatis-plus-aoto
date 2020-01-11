package com.ltt.demo.common.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * request请求中的util
 *
 * @author zk
 * @since 2018/4/18
 */
public class RequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    /**
     * 获取request中的token
     *
     * @param request request
     * @return token/null
     */
    public static String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.substring(7); // The part after "Bearer "
    }

}
