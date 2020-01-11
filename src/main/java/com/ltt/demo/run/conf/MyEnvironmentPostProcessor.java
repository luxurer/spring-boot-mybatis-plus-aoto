package com.ltt.demo.run.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * 外部配置文件路径
 *
 * @author zhangming
 * @date 2019/9/9-15:11
 */
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

			private static final String appPropertiesPath = "app.properties";

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment configurableEnvironment, SpringApplication springApplication) {
		InputStream is = null;
		try {
			Properties properties = new Properties();
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(appPropertiesPath);
			properties.load(is);

			String folderName = properties.getProperty("project.name");

			boolean ifWindows = !"/".equals(System.getProperty("file.separator"));
			String filePath = ifWindows ? properties.getProperty("windows.conf.path") : properties.getProperty("linux.conf.path");
			filePath = MessageFormat.format(filePath, folderName);

			//加载application.properties配置文件
			String systemConfigPath = filePath + System.getProperty("file.separator") + "application.properties";
			System.setProperty("application.properties", systemConfigPath);

			File directory = new File(filePath);
			if (directory.isDirectory()) {
				File[] files = directory.listFiles();
				if (files != null) {
					for (File file : files) {
						configurableEnvironment.getPropertySources().addLast(this.loadProperties(file));
					}
				}
			} else {
				configurableEnvironment.getPropertySources().addLast(this.loadProperties(directory));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private PropertiesPropertySource loadProperties(File file) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(is);
			//读取多个配置文件的时候，每个PropertiesPropertySource的name必须不同，同名的会覆盖
			return new PropertiesPropertySource(file.getName(), properties);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}