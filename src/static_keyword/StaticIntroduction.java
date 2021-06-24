package static_keyword;

import java.util.LinkedList;
import java.util.List;

public class StaticIntroduction {
	
	static {
		x= 2;
	}
	static int x;
	static {
		System.err.println(x);
	}
	public StaticIntroduction(String x, int i) {
		System.err.println("constructor called");
		text = x;
		
		var = myMethod(i);
	}
	static {
		
		System.err.println("inside static block");
		var = 44;
		text = "hello";
	}
	static int var;
	static String text;
	
	
	static int myMethod(int a) {
		System.err.println("inside my method");
		return a*10;
	}
	
	public static void main(String[] args) {
		
		Car ferrari = new Car("Ferrari");
		Car maruti = new Car("Maruti");
		System.err.println("num"+Car.numberOfCars);
		
		System.err.println(var + " " + text);
		StaticIntroduction ojb =new StaticIntroduction("hi", 69);
		ojb.testMethod();
		A objA = new A();
		A.B objB = objA.new B();
		
		A.C objC = new A.C();
		A.C.Demo obj = new A.C.Demo();
		obj.testMethod();
//		objC.x = 21;
//		objC.w = 32;
		A.C.w = 42;
//		A.C.x = 32;
		System.err.println(objC.w);

	}

	public void testMethod() {
		System.err.println("test method");
		myMethod(4);
	}
}
