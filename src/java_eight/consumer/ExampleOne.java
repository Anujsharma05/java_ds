package java_eight.consumer;

import java.util.function.Consumer;

class Hello implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.println("test:" + t);
	}
}

/**
 * Consumer<T> only accepts values void accept(T t)
 * 
 * andThen => default method
 */
public class ExampleOne {

	public static void main(String[] args) {

		Hello h = new Hello();
		h.accept(3);

		Consumer<String> c = str -> System.out.println(str.toUpperCase());
		c.accept("hello world");
	}

}
