package java_eight.functions;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

/*
 * Function is functional interface
 * Function is like predicate. But predicate can only
 * return boolean. Function can return anything
 * 
 * Function<T, R> => T is the input type, R is return type
 * 
 * R apply(T t) apply this function
 * 
 */
public class ExampleOne {

	public static void main(String[] args) {

//		stringLength();
//		numberSquare();
//		removeSpaces();
//		countSpaces();

	}

	static void stringLength() {
		ToIntFunction<String> fn = String::length;
		System.out.println(fn.applyAsInt("hello"));
	}

	static void numberSquare() {
		IntUnaryOperator fn = i -> i * i;
		System.out.println(fn.applyAsInt(5));
	}

	static void removeSpaces() {
//		Function<String, String> removeSpaces = str -> {
//			String[] sArr = str.trim().split(" ");
//			StringBuilder sb = new StringBuilder();
//			for(String s: sArr) {
//				sb.append(s.trim());
//			}
//			
//			return sb.toString();
//		};

		Function<String, String> removeSpaces = str -> str.replace(" ", "");

		String text = "  This    is    Sparta   ";
		System.out.println(removeSpaces.apply(text));
	}

	static void countSpaces() {
		ToIntFunction<String> countSpaces = str -> str.length() - str.replace(" ", "").length();
		String text = "  This    is    Sparta   ";
		System.out.println(text.length());
		System.out.println(countSpaces.applyAsInt(text));
	}

}
