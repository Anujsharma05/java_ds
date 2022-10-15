package bi_predicate_function_consumer;

import java.util.function.BiConsumer;

/*
 * BiConsumer<T, U>
 * 
 * void accept(T t, U u)
 * 
 * andThen()
 */
public class BiConsumerExample {
	public static void main(String args[]) {
		
		basicExample();
	}
	
	static void basicExample() {
		
		BiConsumer<Integer, Integer> c = (a, b) -> System.out.println(a+b);
		
		c.accept(4, 5);
	}
}
