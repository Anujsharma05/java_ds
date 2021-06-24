package oops;

import oops.packages.model.Student;

public class MainClass extends Student{

	private char wheels;
	
	private int headlights;
	
	//no arg
	MainClass() {
		//default
	}
	//parameterized
	MainClass(char wheels) {
		this.wheels = wheels;
	}
	
	public static void main(String[] args) {
		
		MainClass obj = new MainClass();
		System.err.println(obj.wheels == '\u0000');
		
		Student st = new Student();
//		st.name = "fasdf";
	}
}
