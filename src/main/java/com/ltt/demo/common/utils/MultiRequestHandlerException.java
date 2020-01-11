package com.ltt.demo.common.utils;

public class MultiRequestHandlerException extends RuntimeException {

    public MultiRequestHandlerException(String msg){
        super(msg);
    }
    public MultiRequestHandlerException(String msg, Throwable e) {
        super(msg, e);
    }
}
