package loops;

import java.util.Scanner;

public class DoWhileLoop {

	public static void main(String[] args) {

		int n = 0;
		Scanner sc = new Scanner(System.in);
	
		do {
			n = sc.nextInt();
			System.err.println("Number is " + n);
		} while(n!=0);
		
		sc.close();
	}

}
