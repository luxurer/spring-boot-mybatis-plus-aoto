package com.example.mybatisplus;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OtherTest {

	@Test
	public void test2() {
		for (ImportTrainProperty property : ImportTrainProperty.values()) {
			System.out.println("属性:" + property.getName());
			System.out.println(ImportTrainProperty.values().length);
			System.out.println(ImportTrainProperty.values());
			System.out.println(ImportTrainProperty
					.NAME.getType());
		}
	}

	/**
	 * date -> long
	 **/
	@Test
	public void test3() throws Exception {
		List<People> list = new ArrayList<>();
		People p1 = new People("1", 1);
		People p2 = new People("2", 2);
		list.forEach(p -> {
			int sum = 0;
			/*sum += p.getSum();*/
		});
	}

	/**
	 * long to date
	 **/
	@Test
	public void test22() throws Exception {
		String hourAndMin = "400";
		//添零
		hourAndMin = completeCode(hourAndMin);
		//加冒号
		StringBuffer stringBuilder = new StringBuffer(hourAndMin);
		stringBuilder.insert(2, ":");
		System.out.println(stringBuilder);
	}

	private String completeCode(String code) {
		StringBuilder codeBuilder = new StringBuilder(code);
		while (codeBuilder.length() < 4) {
			codeBuilder.insert(0, "0");
		}
		return codeBuilder.toString();
	}

	@Test
	public void test223() {/*
		A c1 = new A("1", "1", "1");
		A c2 = new A("2", "2", "2");
		List list = new ArrayList();
		list.add(c1);
		list.add(c2);
		System.out.println(list.toString());
		list.forEach(c -> {
			if (c1.getCz().equals("1")) {
				c1.setCz("Success");
			}
		});
		System.out.println(list.toString());*/
	}

	@Test
	public void test52() {
		String oldString = "PZ\n" +
				"FPZ\n" +
				"FP2\n" +
				"AF4\n" +
				"AF3\n" +
				"F1\n" +
				"F5\n" +
				"F3\n" +
				"F7\n" +
				"FP1\n" +
				"F2\n" +
				"F4\n" +
				"F6\n" +
				"F8\n" +
				"FT7\n" +
				"FC5\n" +
				"FC3\n" +
				"FC1\n" +
				"FCZ\n" +
				"FC2\n" +
				"FC4\n" +
				"FC6\n" +
				"FT8\n" +
				"T7\n" +
				"C5\n" +
				"C3\n" +
				"C1\n" +
				"CZ\n" +
				"C2\n" +
				"C4\n" +
				"C6\n" +
				"T8\n" +
				"TP7\n" +
				"CP5\n" +
				"CP3\n" +
				"CP1\n" +
				"CPZ\n" +
				"CP4\n" +
				"CP6\n" +
				"TP8\n" +
				"P7\n" +
				"P5\n" +
				"P3\n" +
				"P1\n" +
				"PZ\n" +
				"P2\n" +
				"P4\n" +
				"P6\n" +
				"P8\n" +
				"PO7\n" +
				"PO3\n" +
				"POZ\n" +
				"PO4\n" +
				"PO8\n" +
				"O1\n" +
				"OZ\n" +
				"O2\n" +
				"AF7\n" +
				"AF8\n" +
				"CP2\n" +
				"TP9\n" +
				"TP10\n";
		String newString = "FP1\n" +
				"FPZ\n" +
				"FP2\n" +
				"AF7\n" +
				"AF3\n" +
				"AF4\n" +
				"AF8\n" +
				"F7\n" +
				"F5\n" +
				"F3\n" +
				"F1\n" +
				"FZ\n" +
				"F2\n" +
				"F4\n" +
				"F6\n" +
				"F8\n" +
				"FT7\n" +
				"FC5\n" +
				"FC3\n" +
				"FC1\n" +
				"FCZ\n" +
				"FC2\n" +
				"FC4\n" +
				"FC6\n" +
				"FT8\n" +
				"T7\n" +
				"C5\n" +
				"C3\n" +
				"C1\n" +
				"CZ\n" +
				"C2\n" +
				"C4\n" +
				"C6\n" +
				"T8\n" +
				"TP7\n" +
				"CP5\n" +
				"CP3\n" +
				"CP1\n" +
				"CPZ\n" +
				"CP2\n" +
				"CP4\n" +
				"CP6\n" +
				"TP8\n" +
				"P7\n" +
				"P5\n" +
				"P3\n" +
				"P1\n" +
				"PZ\n" +
				"P2\n" +
				"P4\n" +
				"P6\n" +
				"P8\n" +
				"PO7\n" +
				"PO3\n" +
				"POZ\n" +
				"PO4\n" +
				"PO8\n" +
				"O1\n" +
				"OZ\n" +
				"O2\n" +
				"TP9\n" +
				"TP10\n";
		/*List<String> oldList = new ArrayList<>();
		List<String> newList = new ArrayList<>();*/
		String[] oldSplit = oldString.split("\n");
		/*for (int i = 0; i < oldSplit.length; i++) {
			oldList.add(oldSplit[i]);
			*//*System.out.println(oldSplit[i]);*//*
		}*/
		String[] newSplit = newString.split("\n");
		/*for (int i = 0; i < newSplit.length; i++) {
			newList.add(newSplit[i]);
			*//*System.out.println(newSplit[i]);*//*
		}*/
		printMessage(oldString, newSplit);
		printMessage(newString, oldSplit);
	}

	private void printMessage(String comString, String[] list) {
		System.out.println("字符串里没有:");
		for (int i = 0; i < list.length; i++) {
			if (!comString.contains(list[i])) {
				System.out.println(list[i]);
			}
		}
	}

	/**
	 * date -> long
	 **/
	@Test
	public void test53() throws Exception {

	}

	/**
	 * long to date
	 **/
	@Test
	public void test522() throws Exception {
	}

	@Test
	public void test5223() {
	}

	/**
	 * 导出车次属性
	 */
	public enum ImportTrainProperty {
		/**
		 * 名称
		 */
		NAME(1, "名称"),
		/**
		 * 始发站
		 */
		DEPARTURE_STATION(2, "始发站"),
		/**
		 * 终点站
		 */
		TERMINUS_STATION(3, "终点站"),
		/**
		 * 始发时间
		 */
		DEPARTURE_TIME_INALL(4, "始发时间"),
		/**
		 * 终点时间
		 */
		TERMINUS_TIME_INALL(5, "终点时间"),
		/**
		 * 历经天数
		 */
		N_DAYS(6, "历经天数"),
		/**
		 * 归属部门
		 */
		BELONG_DEPT_ID(7, "归属部门"),

		/**
		 * 站点名称
		 */
		STATION_NAME(8, "站点名称"),
		/**
		 * 发车时间
		 */
		DEPARTURE_TIME(9, "发车时间"),
		/**
		 * 到达时间
		 */
		ARRIVAL_TIME(10, "到达时间"),
		/**
		 * 排序
		 */
		ORDER_NUM(11, "排序"),
		/**
		 * 隔夜天数
		 */
		DAYS(12, "隔夜天数");

		private int type;
		private String name;

		ImportTrainProperty(int type, String name) {
			this.type = type;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public int getType() {
			return type;
		}
	}

	@Data
	public static class People {

		private String id;

		private Integer sum;

		public People(String id, Integer sum) {
			this.id = id;
			this.sum = sum;
		}
	}
}
