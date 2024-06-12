package interfaces;

interface A {
	default void testMethod() {
		System.out.println("test method of interface");
	}
}

interface B {
	default void testMethod() {
		System.out.println("b");
	}
}

class One {
	static void alpha() {

	}
}

class Two extends One {
//	@Override
	static void alpha() {

	}
}

public class InterfaceExample implements A, B {

	@Override
	public void testMethod() {
		A.super.testMethod();
	}

	public static void main(String[] args) {

		InterfaceExample a = new InterfaceExample();
		a.testMethod();
	}

}
