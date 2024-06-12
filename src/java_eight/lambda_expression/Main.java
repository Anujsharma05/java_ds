/**
 * 
 */
package java_eight.lambda_expression;

/**
 * @author anuj.sharma
 *
 * @date 08-Jun-2022
 */

@FunctionalInterface
interface Hello {
	void sayHello();
}

@FunctionalInterface
interface Sum {
	int sum(int a, int b);
}

@FunctionalInterface
interface StringLength {
	int getLength(String s);
}

@FunctionalInterface
interface NumSquare {
	int squareIt(int num);
}

public class Main {
	public static void main(String args[]) {
		Sum s = (a, b) -> a + b;
		System.out.println(s.sum(4, 5));
		
		StringLength sl = str -> str.length();
		System.out.println(sl.getLength("Hello"));
		
		NumSquare ns = num -> num * num;
		System.out.println(ns.squareIt(5));
	}
}
