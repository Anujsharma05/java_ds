package java_eight.bi_predicate_function_consumer;

import java.util.function.BiPredicate;

/*
 * BiPredicate<T, U>
 * 
 * boolean test(T t, U u)
 * 
 * and(), or(), negate()
 */
public class BiPredicateExample {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> bp = (a, b) -> a > b;
		
		System.out.println(bp.test(5, 6));
		System.out.println(bp.test(15, 6));
	}

}
