package unary_binary_operator;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator<T>
 * T apply(T t1, T t2) When param type and return type same for BiFunction
 */
public class BinaryOperatorEx {

	public static void main(String[] args) {
		binaryOperatorEx();
	}
	
	static void binaryOperatorEx() {
		BinaryOperator<String> strConcat = (str1, str2) -> str1.concat(str2);
		System.out.println(strConcat.apply("hello ", "world"));
	}

}
