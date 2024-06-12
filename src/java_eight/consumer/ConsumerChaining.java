package java_eight.consumer;

import java.util.function.Consumer;

class MovieInfo {
	String name;
	String result;
	
	public MovieInfo(String name, String result) {
		super();
		this.name = name;
		this.result = result;
	}
}
public class ConsumerChaining {
	public static void main(String args[]) {
		
		Consumer<MovieInfo> c1 = m -> System.out.println(m.name);
		Consumer<MovieInfo> c2 = m -> System.out.println(m.result);
		Consumer<MovieInfo> c3 = m -> System.out.println("store in database");
		
		MovieInfo m = new MovieInfo("Bahubali", "Hit");
		c1.andThen(c2).andThen(c3).accept(m);
	}
}
