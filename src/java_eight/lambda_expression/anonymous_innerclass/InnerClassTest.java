package java_eight.lambda_expression.anonymous_innerclass;

public class InnerClassTest {
	
	static class Inner {
		static void test() {}
		void hello() {}
	}
	
	public static void main(String args[]) {
		InnerClassTest.Inner i = new InnerClassTest.Inner();
		Inner.test();
		i.hello();
	}
}
