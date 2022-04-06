
/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Person {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// TODO:添加setName的重载方法，重载方法通过参数数量和类型区分
	public void setName(String first_name, String second_name) {
		this.name = first_name + " " + second_name;
	}

}
