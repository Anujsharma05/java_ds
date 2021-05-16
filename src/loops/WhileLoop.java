package loops;

public class WhileLoop {

	public static void main(String[] args) {

		int a = 12345;
		int sum = 0;
		
		while(a > 0) {
			int q = a/10;
			int r = a%10;
			sum = sum + r;
			
			a = q;
		}
		
		System.err.println(sum);
	}

}
