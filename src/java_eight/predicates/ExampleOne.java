package java_eight.predicates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/*
 * Predicate is functional interface
 * Predicate perform some condition and return boolean value
 * 
 * Predicate<T> => T is input type
 * 
 * boolean test(T) test this condition
 * 
 * default methods=> and, or, negate
 * p1.and(p2)
 * p1.or(p2)
 * p1.negate() => perform ! operation
 * 
 * static method => isEqual
 */
public class ExampleOne {
	public static void main(String args[]) {

//		basicExample();
//		nameWithK();
//		removeBlankFromArr();
	}

	static void basicExample() {
		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i % 2 == 0;
		System.out.println(p1.test(44));
		System.out.println(p2.test(1));

		IntPredicate ip1 = i -> i > 11;
		System.out.println(ip1.negate().test(42));

		Predicate<String> p3 = str -> str.length() > 5;
		System.out.println(p3.test("hello world"));

		Predicate<Collection> p4 = c -> c.isEmpty();
		ArrayList<String> al = new ArrayList<>();
		al.add("daf");
		System.out.println(p4.test(al));

		Predicate<Integer> p5 = p1.and(p2);
		System.out.println(p5.test(4));

		Predicate<Integer> p6 = p1.or(p2);
		System.out.println(p6.test(4));

		Predicate<Integer> p7 = p5.negate();
		System.out.println(p7.test(4));
	}

	static void nameWithK() {
		String[] names = { "Katrina", "Mallika", "Kajal", "Kareena", "Selmon" };

		Predicate<String> p = str -> str.charAt(0) == 'K';

		for (String name : names) {
			if (p.test(name)) {
				System.out.println(name);
			}
		}
	}

	static void removeBlankFromArr() {
		String[] names = { "Durga", " ", "", null, "Selmon" };

		Predicate<String> isNotNull = str -> str != null && str.trim().length() > 0;
		for (String name : names) {
			if (isNotNull.test(name)) {
				System.out.println(name);
			}
		}
	}
}
