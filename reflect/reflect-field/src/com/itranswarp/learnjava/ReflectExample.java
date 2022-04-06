package com.itranswarp.learnjava;

public class ReflectExample {
	public static void main(String[] args) {
		printClassInfo("".getClass());				// String类
		printClassInfo(Runnable.class);				// Runnable类
		printClassInfo(java.time.Month.class);		// Month类
		printClassInfo(String[].class);				// String数组类
		printClassInfo(int.class);					// int类型(基本类型也有class实例)
	}

	static void printClassInfo(Class cls) {
		System.out.println("Class name: " + cls.getName());
		System.out.println("Simple name: " + cls.getSimpleName());
		if (cls.getPackage() != null) {
			System.out.println("Package name: " + cls.getPackage().getName());
		}
		System.out.println("is interface: " + cls.isInterface());
		System.out.println("is enum: " + cls.isEnum());
		System.out.println("is array: " + cls.isArray());
		System.out.println("is primitive: " + cls.isPrimitive());
	}

}
