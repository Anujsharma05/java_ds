package consumer;

import java.util.function.Consumer;

/*
 * Consumer<T> only accepts values
 * void accept(T t)
 * 
 * andThen => default method
 */
public class ExampleOne {

	public static void main(String[] args) {

		Consumer<String> c = str -> System.err.println(str);
		
		c.accept("hello world");
	}

}
