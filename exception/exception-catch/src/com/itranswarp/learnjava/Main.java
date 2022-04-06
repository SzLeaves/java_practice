package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String a = "12";
		String b = "x9";
		// TODO: 捕获异常并处理
		// 捕获多个异常时，有继承关系的要把子类写在前面，没有继承关系但处理逻辑相同的用 | 隔开
		try {
			int c = stringToInt(a);
			int d = stringToInt(b);
			System.out.println(c * d);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static int stringToInt(String s) {
		return Integer.parseInt(s);
	}
}
