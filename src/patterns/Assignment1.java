package patterns;

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for(int i = 1 ; i<= n; i++) {
			
			for(int j = 1 ; j <= (n - i) ; j++) {
				System.err.print("  ");
			}
			
			for(int j = 1 ; j <= i; j++) {
				System.err.print(" *  ");
			}
			
			System.err.println();
		}
	}
}
