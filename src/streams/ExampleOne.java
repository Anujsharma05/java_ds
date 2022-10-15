package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleOne {

	static void streamOfMethod() {
		
		Stream<Integer> s = Stream.of(3,4,2,6,43,2,52,22);
		s.forEach(System.out::println);
		
	}
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(14);
		list.add(5);
		list.add(66);
		list.add(9);
		list.add(55);
		list.add(68);
		
//		filterExample(list);
//		mapExample(list);
//		countMethod(list);
//		sortedMethod(list);
//		minMethod(list);
//		maxMethod(list);
//		forEachMethod(list);
//		toArrayMethod(list);
		streamOfMethod();
	}

	private static void mapExample(ArrayList<Integer> list) {
		
		IntUnaryOperator f = i -> i * 2;
		
		/**
		 * Stream interface
		 * stream() default method in Collection interface
		 * 
		 */
		Stream<Integer> streamObj = list.stream();
		
		List<Integer> doubledList = streamObj.map(f::applyAsInt).collect(Collectors.toList());
		System.out.println(doubledList);
	}

	static void filterExample(ArrayList<Integer> list) {
		
		IntPredicate p = i -> i%2==0;
		
		List<Integer> evenList = list.stream().filter(p::test).collect(Collectors.toList());
		System.out.println(evenList);
	}
	
	static void countMethod(ArrayList<Integer> list) {
		
		long count = list.stream().filter(i -> i > 20).count();
		System.out.println(count);
	}
	
	static void sortedMethod(ArrayList<Integer> list) {
		//Default sorting order
		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
		
		//custom sorting order
		List<Integer> sortedDesc = list.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
		System.out.println(sortedDesc);
	}
	
	static void minMethod(ArrayList<Integer> list) {
		Integer min = list.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(min);
	}
	
	static void maxMethod(ArrayList<Integer> list) {
		Integer max = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(max);
	}
	
	static void forEachMethod(ArrayList<Integer> list) {
		list.stream().forEach(System.out::println);
	}
	
	static void toArrayMethod(ArrayList<Integer> list) {
		Integer[] arr = list.stream().toArray(Integer[]::new);
		System.out.println(Arrays.deepToString(arr));
	}
}
