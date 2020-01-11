package com.ltt.demo.common.common.exception;

/**
 * 第三方调用 异常
 *
 * @author zhangming
 * @date 2019/2/28 23:40
 */
public class ThirdApiException extends RuntimeException {

    public ThirdApiException(String message) {
        super(message);
    }

    public ThirdApiException(String message, Throwable e) {
        super(message,e);
    }
}
