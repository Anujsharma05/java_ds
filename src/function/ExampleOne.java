package function;import java.util.function.Function;

/*
 * Function is functional interface
 * Function is like predicate. But predicate can only
 * return boolean. Function can return anything
 * 
 * Function<T, R> => T is the input type, R is return type
 * 
 * R apply(T t) apply this function
 * 
 */
public class ExampleOne {

	public static void main(String[] args) {
		
//		stringLength();
//		numberSquare();
//		removeSpaces();
		countSpaces();
	}
	
	static void stringLength() {
		
		Function<String, Integer> fn = str -> str.length();
		System.out.println(fn.apply("hello"));
	}
	
	static void numberSquare() {
		Function<Integer, Integer> fn = i -> i * i;
		System.out.println(fn.apply(5));
	}
	
	static void removeSpaces() {
//		Function<String, String> removeSpaces = str -> {
//			String[] sArr = str.trim().split(" ");
//			StringBuilder sb = new StringBuilder();
//			for(String s: sArr) {
//				sb.append(s.trim());
//			}
//			
//			return sb.toString();
//		};
		
		Function<String, String> removeSpaces = str -> str.replace(" ", "");
		
		String text = "  This    is    Sparta   ";
		System.out.println(removeSpaces.apply(text));
	}
	
	static void countSpaces() {
		Function<String, Integer> countSpaces = str -> str.length() - str.replace(" ", "").length();
		String text = "  This    is    Sparta   ";
		System.out.println(text.length());
		System.out.println(countSpaces.apply(text));
	}

}
