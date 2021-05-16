package advanced_patterns;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
//		for(int i = 1 ; i<= n ; i++) {
//			for(int j = 1 ; j <=i ; j++) {
//				System.err.print("* ");
//			}
//			
//			System.err.println();
//		}
//		
//		for(int i = n - 1; i >= 1 ; i--) {
//			for(int j = i ; j >= 1 ; j--) {
//				System.err.print("* ");
//			}
//			System.err.println();
//		}
		
		int rows = 2*n - 1;
		for(int i=1 ; i<= rows ; i++) {
			if(i <= n) {
				for(int j = 1 ; j <= i; j++) {
					System.err.print("* ");
				}
			} else {
				for(int j = rows - i + 1; j>= 1; j--) {
					System.err.print("* ");
				}
			}
			System.err.println();
		}
	}
}
