package introduction;

import java.util.Arrays;

public class VariableArguments {

	public static void main(String[] args) {
		
		print(1,2,3,4,5);
		print(2,4,6);
		multipleArgs(3,5);
		multipleArgs(1,3, "Chitku", "Pepdu", "Gingu");
	}
	
	private static void multipleArgs(int a, int b, String ...s) {
		System.out.println(a + " " + b);
		System.out.println(Arrays.toString(s));
	}
	
	private static void print(int ...v) {
		System.out.println(Arrays.toString(v));
	}

}
