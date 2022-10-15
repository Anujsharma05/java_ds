package consumer;

import java.util.ArrayList;
import java.util.function.Consumer;

class Movie {
	String name;
	String actor;
	String actress;
	
	public Movie(String name, String actor, String actress) {
		this.name = name;
		this.actor = actor;
		this.actress = actress;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s", name, actor, actress);
	}
}

public class ExampleTwo {
	public static void main(String args[]) {
		ArrayList<Movie> list = new ArrayList<>();
		populate(list);
		
//		Consumer<ArrayList<Movie>> c = l -> {
//			l.forEach(movie -> System.out.println(movie));
//		};
//		c.accept(list);
		
		Consumer<Movie> c = movie -> System.err.println(movie);
		
		list.forEach(c);
	}

	private static void populate(ArrayList<Movie> list) {
		
		list.add(new Movie("Bahubali","Prabhas" ,"Tamanna"));
		list.add(new Movie("Dabang","Selmon" ,"Sonakshi"));
		list.add(new Movie("Raees","Shahrukh" ,"Sunny"));
		list.add(new Movie("Sultan","Selmon" ,"Anushka"));
		
	}
}
