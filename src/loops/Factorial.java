package loops;

public class Factorial {
	public static void main(String[] args) {
		
		int n = 5;
		int result = 1;
		
		for(int i = n ; i > 0 ; i--) {
			result *= i;
		}
		
		System.err.println(result);
	}
}
