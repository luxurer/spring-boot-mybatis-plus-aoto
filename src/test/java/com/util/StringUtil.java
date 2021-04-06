package com.util;

/**
 * Copyright 2004-2020 by xdja.com  All rights reserved.
 *
 * @author xxx
 * @version 1.0.0
 * @ClassName StringUtil.java
 * @Description TODO
 * @createTime 2021/04/05 23:12:46
 */
public class StringUtil {
	public static String ReplacementInfo(String string, String keyword, String before, String rear) {
		StringBuilder stringBuilder = new StringBuilder(string);
		int index = stringBuilder.indexOf(keyword);//字符第一次出现的位置
		while (index != -1) {
			stringBuilder.insert(index, before);
			stringBuilder.insert(index + before.length() + keyword.length(), rear);
			index = stringBuilder.indexOf(keyword, index + before.length() + keyword.length() + rear.length() - 1);
			//下一次出现的位置
		}
		return stringBuilder.toString();
	}
}
