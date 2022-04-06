package szleave.practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.CheckedInputStream;

// 反射调用构造方法
public class Main {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
												  IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<Person> p_class = Person.class;

		// 带参数的构造方法
		Constructor<Person> p_con_args = p_class.getDeclaredConstructor(String.class, int.class);
		// 使用newInstance调用，将直接通过调用构造方法返回新的实例
		Person p_new_args = p_con_args.newInstance("Hello Constructor", 123);

		// 无参数的构造方法
		Constructor<Person> p_con = Person.class.getDeclaredConstructor();
		// 调用非public的Constructor时，必须首先通过setAccessible(true)设置允许访问
		// setAccessible(true)可能会失败
		p_con.setAccessible(true);
		Person p_new = p_con.newInstance();

		System.out.println(p_new_args.getName());
		System.out.println(p_new_args.getAge());
	}

}
