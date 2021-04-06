package com.util;

/**
 * Copyright 2004-2020 by xdja.com  All rights reserved.
 *
 * @author xxx
 * @version 1.0.0
 * @ClassName PicToPdfUtil.java
 * @Description TODO
 * @createTime 2021/04/05 22:22:29
 */

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
/*import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;*/
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.imageio.ImageIO;

import static com.util.StringUtil.ReplacementInfo;

public class PicToPdfUtil {

	public static final String PDF = ".pdf";
	public static Long COUNT = 0L;

	public static void convert(String source, String target) {
		Document document = new Document();
		// 设置文档页边距
		document.setMargins(0, 0, 0, 0);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(target);
			PdfWriter.getInstance(document, fos);
			// 打开文档
			document.open();
			// 获取图片的宽高
			Image image = Image.getInstance(source);
			float imageHeight = image.getScaledHeight();
			float imageWidth = image.getScaledWidth();
			// 设置页面宽高与图片一致
			Rectangle rectangle = new Rectangle(imageWidth, imageHeight);
			document.setPageSize(rectangle);
			// 图片居中
			image.setAlignment(Image.ALIGN_CENTER);
			// 新建一页添加图片
			document.newPage();
			document.add(image);
		} catch (Exception ioe) {
			System.out.println(ioe.getMessage());
		} finally {
			// 关闭文档
			document.close();
			try {
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param imageFolderPath 图片文件夹地址
	 * @param pdfPath         PDF文件保存地址
	 */
	/*public static void toPdf(String imageFolderPath, String pdfPath) {
		try {
			// 图片文件夹地址
			// String imageFolderPath = "D:/Demo/ceshi/";
			// 图片地址
			String imagePath = null;
			// PDF文件保存地址
			// String pdfPath = "D:/Demo/ceshi/hebing.pdf";
			// 输入流
			FileOutputStream fos = new FileOutputStream(pdfPath);
			// 创建文档
			Document doc = new Document(null, 0, 0, 0, 0);
			//doc.open();
			// 写入PDF文档
			PdfWriter.getInstance(doc, fos);
			// 读取图片流
			BufferedImage img = null;
			// 实例化图片
			Image image = null;
			// 获取图片文件夹对象
			File file = new File(imageFolderPath);
			File[] files = file.listFiles();
			// 循环获取图片文件夹内的图片
			for (File file1 : files) {
				if (file1.getName().endsWith(".png")
						|| file1.getName().endsWith(".jpg")
						|| file1.getName().endsWith(".gif")
						|| file1.getName().endsWith(".jpeg")
						|| file1.getName().endsWith(".tif")) {
					// System.out.println(file1.getName());
					imagePath = imageFolderPath + file1.getName();
					System.out.println(file1.getName());
					// 读取图片流
					img = ImageIO.read(new File(imagePath));
					// 根据图片大小设置文档大小
					doc.setPageSize(new Rectangle(img.getWidth(), img
							.getHeight()));
					// 实例化图片
					image = Image.getInstance(imagePath);
					// 添加图片到文档
					doc.open();
					doc.add(image);
				}
			}
			// 关闭文档
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * @param imageFolderPath 图片文件夹地址
	 */
	public static void toPdf(String imageFolderPath, String name) {
		try {
			// 图片文件夹地址
			// String imageFolderPath = "D:/Demo/ceshi/";
			// 图片地址
			String imagePath = null;
			// PDF文件保存地址
			// String pdfPath = "D:/Demo/ceshi/hebing.pdf";
			// 输入流
			//TODO 输出目录将凭证改为凭证_Generate
			String replacePath = ReplacementInfo(imageFolderPath, "凭证", "", "_Generate2");
			makeDir(replacePath);
			// 创建文档
			/*Document doc = new Document(null, 0, 0, 0, 0);*/
			com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
			doc.setMargins(0, 0, 0, 0);
			// 读取图片流
			BufferedImage img = null;
			// 实例化图片
			Image image = null;
			// 获取图片文件夹对象
			File file = new File(imageFolderPath);
			File[] files = file.listFiles();
			Boolean flag = false;
			for (File file1 : files) {
				if (file1.getName().endsWith(".png")
						|| file1.getName().endsWith(".jpg")
						|| file1.getName().endsWith(".gif")
						|| file1.getName().endsWith(".jpeg")
						|| file1.getName().endsWith(".tif")
						|| file1.getName().endsWith(".PNG")
						|| file1.getName().endsWith(".JPG")
						|| file1.getName().endsWith(".GIF")
						|| file1.getName().endsWith(".JPEG")
						|| file1.getName().endsWith(".TIF")
				) {
					flag = true;
				}
			}
			if (flag) {
				FileOutputStream fos = new FileOutputStream(replacePath + "/" + name + PDF);
				// 写入PDF文档
				PdfWriter.getInstance(doc, fos);

				doc.open();
				// 循环获取图片文件夹内的图片
				for (File file1 : files) {
					if (file1.getName().endsWith(".png")
							|| file1.getName().endsWith(".jpg")
							|| file1.getName().endsWith(".gif")
							|| file1.getName().endsWith(".jpeg")
							|| file1.getName().endsWith(".tif")
							|| file1.getName().endsWith(".PNG")
							|| file1.getName().endsWith(".JPG")
							|| file1.getName().endsWith(".GIF")
							|| file1.getName().endsWith(".JPEG")
							|| file1.getName().endsWith(".TIF")) {
						COUNT++;
						// System.out.println(file1.getName());
						imagePath = imageFolderPath + file1.getName();
						System.out.println("生成第" + COUNT + "张图片:  " + file1.getName());
						// 读取图片流
						img = ImageIO.read(new File(imagePath));
						// 根据图片大小设置文档大小
						doc.setPageSize(new Rectangle(img.getWidth(), img
								.getHeight()));
						// 实例化图片
						image = Image.getInstance(imagePath);
						// 添加图片到文档
						doc.newPage();
						doc.add(image);
					}
				}
				// 关闭文档
				doc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void makeDir(String path) {
		File file = new File(path);
		//如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("//不存在 创建！");
			file.mkdir();
		} else {
			System.out.println("//目录存在");
		}
	}
}
