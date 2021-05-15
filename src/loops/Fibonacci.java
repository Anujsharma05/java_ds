package loops;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		int a = 0, b = 1;
		int n, c;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		if(n <= 1) {
			System.err.println("0");
		} else if(n == 2) {
			System.err.println("0 1");
		} else {
			System.err.print("0 1 ");
			for(int i = 0 ; i < n-2 ; i++) {
				c = a + b;
				System.err.print(c + " ");
				a = b;
				b = c;
			}
		}
	}
}
