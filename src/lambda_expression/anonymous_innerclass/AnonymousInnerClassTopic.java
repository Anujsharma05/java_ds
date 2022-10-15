/**
 * 
 */
package lambda_expression.anonymous_innerclass;

/**
 * @author anuj.sharma
 *
 * @date 11-Jun-2022
 */

@FunctionalInterface
interface MyInterface {
	void hello();
}

abstract class MyAbstractClass {
	abstract void hi();
}

class MyConcreteClass {
	public void inner() {
		
	}
}

//Lambda Function must require Functional Interface
//ie. Concrete, Abstract Class extending anonymous class cannot be converted to lambda
public class AnonymousInnerClassTopic {
	public static void main(String args[]) {
		
		MyInterface mi = () -> System.out.println("hello");
		mi.hello();
		
		//lambda not possible
		MyAbstractClass mac = new MyAbstractClass() {
			@Override
			void hi() {
				System.out.println("hi");
			}
		};
		
		mac.hi();
		
		//lambda not possible
		MyConcreteClass mcc = new MyConcreteClass() {
			@Override
			public void inner() {
				System.out.println("inner class method");
			}
		};
		
		mcc.inner();
	}
}
