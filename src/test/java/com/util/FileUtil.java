package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2004-2020 by xdja.com  All rights reserved.
 *
 * @author xxx
 * @version 1.0.0
 * @ClassName FileUtil.java
 * @Description TODO
 * @createTime 2021/04/05 22:33:53
 */
public class FileUtil {
	/**
	 * @Author：
	 * @Description：获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件，所以不用递归获取
	 * @Date：
	 */
	public static List<String> getFiles(String path) {
		List<String> files = new ArrayList<String>();
		File file = new File(path);
		File[] tempList = file.listFiles();

		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) {
				files.add(tempList[i].toString());
				//文件名，不包含路径
				//String fileName = tempList[i].getName();
			}
			if (tempList[i].isDirectory()) {
				//这里就不递归了，
			}
		}
		return files;
	}

}
