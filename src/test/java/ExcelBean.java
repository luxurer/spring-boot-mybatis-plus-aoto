import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright 2004-2020 by xdja.com  All rights reserved.
 *
 * @author xxx
 * @version 1.0.0
 * @ClassName ResultBean.java
 * @Description TODO
 * @createTime 2020/10/17 16:42:06
 */
@Data
@Slf4j
public class ExcelBean {
	private String ZCZB;
	private String ZGSWJ_DM;
	private String ZCDZ;
	private String SDH;
	/**
	 * 手机号
	 */
	private String BSRYDDH;
	/**
	 * 客户名称
	 */
	private String NSRMC;
	private String HY_DM;
	private String SCJYDZXZQHSZ_DM;
	private String BSRGDDH;
	private String NSRSBH;
	private String SCJYDZ;
	private String FDDBRYDDH;
	private String BSRXM;
	private String NSRLX_DM;
	private String DJXH;
	private String DJZCLX_DM;
	private String CYRS;
	private String BSRSFZJHM;
	private String FDDBRXM;
	private String NSRZGLX_DM;
	private String NSRZT_DM;
	private String NSRLX_MC;
	private String SHXYDM;
	private String ZCDZXZQHSZ_DM;
	private String JYFW;
	private String FDDBRGDDH;

	public static  ExcelBean getExcelBean(JSONObject jsonObject) {
		 ExcelBean excelBean = new  ExcelBean();
		String[] filedName = getFiledName(excelBean);

		List<String> filedNames = Arrays.asList(getFiledName(excelBean));
		for (int i = 0; i < filedNames.size(); i++) {
			String key = filedNames.get(i);
			String value = jsonObject.getString(key);
			setFieldValueByName(key, excelBean, value);
		}
		return excelBean;
	}

	/**
	 * 获取属性名数组
	 */
	static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/* 根据属性名获取属性值
	 * */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[]{});
			Object value = method.invoke(o, new Object[]{});
			return value;
		} catch (Exception e) {

			return null;
		}
	}

	/* 根据属性名赋值
	 * */
	private static void setFieldValueByName(String fieldName, Object o, String value) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[]{});
			method.invoke(o, value);
		} catch (Exception e) {
			log.info("" + e);
		}
	}

}
