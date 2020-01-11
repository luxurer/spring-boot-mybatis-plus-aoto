package com.ltt.demo.common.common.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class BeanUtil {

	private final static WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

	public static <T> T getBean(Class<T> clz) {
		return wac.getBean(clz);
	}

	public static <T> T getBean(String beanName, Class<T> tClass) {
		return wac.getBean(beanName, tClass);
	}

    public static Object getBean(String beanName) {
        return wac.getBean(beanName);
    }
}
