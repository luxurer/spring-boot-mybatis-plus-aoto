package com.ltt.demo.common.common.utils;


import java.util.*;

public class EmptyUtil {

    public static final String STRING = "";
    public static final Set<?> SET = Collections.EMPTY_SET;
    public static final List<?> LIST = Collections.EMPTY_LIST;
    public static final Map<?, ?> MAP = Collections.EMPTY_MAP;


    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
    public static boolean isNotEmpty(Map<?, ?> map){
        return !isEmpty(map);
    }
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
    public static boolean isEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }
}
