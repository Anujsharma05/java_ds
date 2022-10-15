/**
 * 
 */
package default_static_methods;

/**
 * @author anuj.sharma
 *
 * @date 11-Jun-2022
 */

interface Left {
	default void m1() {
		System.out.println("default method m1 in Left");
	}
	
	String toString();
}

interface Right {
	default void m1() {
		System.out.println("default method m1 in Rigth");
	}
}

//must override because same method name in both interfaces
class A implements Left, Right {

	@Override
	public void m1() {
//		to get left implementation
//		Left.super.m1();
		
//		to get right implementation
//		Right.super.m1();
		
//		or provide own implementation below
	}
	
}

//override m1
class B implements Left {
	@Override
	public void m1() {
		System.out.println("m1 overridden");
	}
}
public class DefaultMethodExample {
	public static void main(String args[]) {
		A a = new A();
		a.m1();
		
		B b = new B();
		b.m1();
	}
}
