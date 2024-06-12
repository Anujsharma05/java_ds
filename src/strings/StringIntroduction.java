package strings;

import java.util.function.Function;

public class StringIntroduction {
	static String name;

	public static void main(String[] args) {

		String a = "Anuj";

		String b = new String("Anuj");
		String d = "Anuj";

		String c = d.substring(0, 4);
//	System.err.println(d == c);

		System.out.println(name);

		char ch = 'H';
		System.out.println((char) 90);

		char abc = '2';
		int i = (int) (abc);
		System.out.println(i);

		Function<String, String> upper = str -> str.toUpperCase();
//		System.out.println("heelo".transform(upper));
	}
}
