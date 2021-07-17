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
		HelloWorld hw = HelloWorld.getInstance();
		hw.count = 32;
		HelloWorld h1 = HelloWorld.getInstance();
		System.err.println(h1.count);
	}
}

class HelloWorld {
	
	int count;
	
	private static HelloWorld INSTANCE = null;
	private HelloWorld() {
	}
	
	public static HelloWorld getInstance() {
		if(INSTANCE == null) { //optimising INSTANCE object creation only when object required
			INSTANCE = new HelloWorld();
		}
		return INSTANCE;
	}
}
