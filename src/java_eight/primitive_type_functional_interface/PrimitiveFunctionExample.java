package java_eight.primitive_type_functional_interface;

import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

/**
 * IntFunction<R> => input type int return type R
 *
 * ToIntFunction<T> => input type T return type int int applyAsInt(T t)
 *
 */
public class PrimitiveFunctionExample {
	public static void main(String argsp[]) {
		intFunctionEx();
		toIntFunctionEx();
		intToDoubleFunctionEx();
	}

	private static void intFunctionEx() {

		IntFunction<Integer> getSquare = i -> i * i;

		System.out.println(getSquare.apply(4));

	}

	private static void toIntFunctionEx() {

//		ToIntFunction<String> getLength = str -> str.length();
		ToIntFunction<String> getLength = String::length;

		System.out.println(getLength.applyAsInt("Anuj"));

	}

	private static void intToDoubleFunctionEx() {

		IntToDoubleFunction getSquareRoot = Math::sqrt;

		System.out.println(getSquareRoot.applyAsDouble(9));

	}

}
