package com.itranswarp.learnjava;

import java.lang.reflect.Method;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射调用setName和setAge方法:

		// 新建指向p的Class实例变量
		Class p_class = p.getClass();
		
		// 使用反射获取指定实例的成员方法信息（名字 + 参数类型）
		Method p_setName = p_class.getMethod("setName", String.class);
		Method p_setAge = p_class.getMethod("setAge", int.class);

		// 设置访问private权限
		p_setName.setAccessible(true);
		p_setAge.setAccessible(true);

		// 通过反射调用
		p_setName.invoke(p, "Xiao Ming");
		p_setAge.invoke(p, 20);

		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
	}
}
