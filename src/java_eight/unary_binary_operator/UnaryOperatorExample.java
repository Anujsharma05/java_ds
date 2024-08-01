package java_eight.unary_binary_operator;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 *	UnaryOperator<T> => input return type same(T)
 *	T apply(T t)
 *
 *	IntUnaryOperator
 *	int applyAsInt(int i)
 */
public class UnaryOperatorExample {
	public static void main(String[] args) {

		unaryOperatorEx();
		intUnaryOperatorEx();
	}
	
	static void unaryOperatorEx() {
		UnaryOperator<Integer> u = i -> i * i;
		Integer output = u.apply(10);
		System.out.println(output);
	}

	//Int, Long, Double
	static void intUnaryOperatorEx() {
		IntUnaryOperator iu = i -> i * i;
		System.out.println(iu.applyAsInt(5));
	}
}
