
public class Person {

	// TODO

	String name;

	// 静态字段（在class中）
	public static int counts = 0;

	public Person(String name) {
		this.name = name;
	}

	public static int getCount() {
		return ++counts;
	}

}