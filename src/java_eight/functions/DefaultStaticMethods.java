package java_eight.functions;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

/*
 * f1.andThen(f2) => perform f1 then perform f2
 * 
 * f1.compose(f2) => perform f2 then perform f1
 * 
 * identity() - Static method, return same value as input
 * 
 */
public class DefaultStaticMethods {
	public static void main(String[] args) {

//		exampleOne();
//		exampleTwo();
		staticExample();

		IntBinaryOperator b = (s1, s2) -> s1 + s2;
		b.applyAsInt(3, 4);
	}

	private static void staticExample() {
		UnaryOperator<String> fn = UnaryOperator.identity();
		System.out.println(fn.apply("Anuj"));

	}

	static void exampleOne() {
		Function<String, String> f1 = str -> str.trim();
		Function<String, String> f2 = str -> str.toUpperCase();

		System.out.println(f1.apply("  hello world   "));
		System.out.println(f2.apply("  hello world   "));

		System.out.println(f1.andThen(f2).apply("  hello world   "));

		System.out.println(f1.compose(f2).apply("  hello world   "));
	}

	static void exampleTwo() {
		Function<Integer, Integer> f1 = i -> i + i;
		Function<Integer, Integer> f2 = i -> i * i * i;

		System.out.println(f1.andThen(f2).apply(2));
		System.out.println(f1.compose(f2).apply(2));
		System.out.println(f2.andThen(f1).apply(2));
	}

}
