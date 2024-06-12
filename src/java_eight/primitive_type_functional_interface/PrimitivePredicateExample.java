package java_eight.primitive_type_functional_interface;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/**
 * 
 * boolean test(int i)
 *
 */
public class PrimitivePredicateExample {
	public static void main(String argsp[]) {
		intPredicateEx();

	}

	static void intPredicateEx() {
//		Predicate<Integer> pred = i -> i % 2 == 0;
//		System.out.println(pred.test(3));

		IntPredicate ip = i -> i % 2 == 0;
		System.out.println(ip.test(2));
		System.out.println(ip.test(3));
		System.out.println(ip.test(52));
	}

	static void longPredicateEx() {
		LongPredicate ip = i -> i % 2 == 0;

		System.out.println(ip.test(2L));
		System.out.println(ip.test(3L));
		System.out.println(ip.test(52L));
	}

	static void doublePredicateEx() {
		DoublePredicate ip = i -> i % 2 == 0;

		System.out.println(ip.test(2d));
		System.out.println(ip.test(3d));
		System.out.println(ip.test(52d));
	}
}
