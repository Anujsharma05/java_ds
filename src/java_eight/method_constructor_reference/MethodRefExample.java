package java_eight.method_constructor_reference;

/**
 * Double colon operator(::) for method reference
 */
@FunctionalInterface
interface Interf {
	void m1();
}

@FunctionalInterface
interface Interf2 {
	int m3();
}
public class MethodRefExample {
	static void m2() {
		System.out.println("static m2 referred by m1");
	}
	
	int m4() {
		System.out.println("instance method referred");
		return -1;
	}
	
	int m2(int a) {
		return -1;
	}
	public static void main(String args[]) {
		
		Interf i = MethodRefExample::m2;
		i.m1();
		
		MethodRefExample obj = new MethodRefExample();
		
		Interf2 i2 = obj :: m4;
		i2.m3();
	}
}
