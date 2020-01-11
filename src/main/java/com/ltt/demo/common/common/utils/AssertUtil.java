package com.ltt.demo.common.common.utils;

import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.common.common.exception.ThirdApiException;
import org.apache.commons.lang3.StringUtils;

/**
 * 数据验证类
 *
 * @author zhangming
 * @date 2019/6/25
 */
public class AssertUtil {

    public static String escapeChar = "/";

    /**
     * pcs系统数据校验
     *
     * @param express
     * @param msg
     */
    public static void sysValidate(boolean express, String msg) {
        if (express) {
            throw new ServiceException(msg);
        }
    }

    /**
     * 第三方调用 数据校验
     *
     * @param express
     * @param msg
     */
    public static void apiValidate(boolean express, String msg) {
        if (express) {
            throw new ThirdApiException(msg);
        }
    }

    public static String specialCharHandle(String str) {
        if (StringUtils.isNotBlank(str)) {
            str = str.replaceAll("'", "''")
                    .replaceAll(escapeChar, escapeChar + escapeChar)
                    .replaceAll("%", escapeChar + "%")
                    .replaceAll("_", escapeChar + "_");
        }
        return str;
    }
}
