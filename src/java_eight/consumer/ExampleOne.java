package java_eight.consumer;

import java.util.function.Consumer;

class Hello implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("test");

	}

}

/*
 * Consumer<T> only accepts values void accept(T t)
 * 
 * andThen => default method
 */
public class ExampleOne {

	public static void main(String[] args) {

		Consumer<String> c = str -> System.err.println(str);

		c.accept("hello world");
	}

}
