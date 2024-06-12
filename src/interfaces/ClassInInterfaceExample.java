package interfaces;

interface Abcd {

	default void test() {
		System.out.println("abcd");
	}

	class Mnop {
		public void testMethod(String caller) {
			System.out.println("test method: " + caller);
		}

		static void hello() {
			System.out.println("hello");
		}
	}
}

interface Bcde {
	default void test() {
		System.out.println("bcde");
	}
}

class Efgh implements Abcd, Bcde {

	public void test() {
		Bcde.super.test();
	}

	public void testInterfaceMethod() {
		Mnop op = new Mnop();
		op.testMethod("efgh");
		Mnop.hello();
	}
}

public class ClassInInterfaceExample {
	public static void main(String[] args) {
		Efgh ef = new Efgh();
		ef.testInterfaceMethod();

		Abcd.Mnop op = new Abcd.Mnop();
		op.testMethod("main");
		Abcd.Mnop.hello();

		ef.test();
	}
}
