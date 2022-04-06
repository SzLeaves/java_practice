package com.itranswarp.learnjava;

import java.lang.reflect.Field;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射给name和age字段赋值:
		
		// 新建指向Person的Class变量
		Class p_class = p.getClass();

		// 新建指向p实例字段的Field变量
		Field p_field_name = p_class.getDeclaredField("name");
		Field p_field_age = p_class.getDeclaredField("age");

		// 设置访问权限访问private字段
		p_field_name.setAccessible(true);
		p_field_age.setAccessible(true);
		
		// 通过set方法给字段赋值
		p_field_name.set(p, "Xiao Ming");
		p_field_age.set(p, 20);

		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
	}
}
