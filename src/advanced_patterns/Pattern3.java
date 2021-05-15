package advanced_patterns;

import java.util.Scanner;

public class Pattern3 {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for(int i = 1 ; i<= n; i++) {
			
			if(i==1 || i==n) {
				for(int j = 1; j<=i; j++) {
					System.err.print("* ");
				}
			} else {
				System.err.print("*");
				for(int j = 1; j <= 2*(i-1) - 1; j++) {
					System.err.print(" ");
				}
				System.err.print("*");
			}
			System.err.println();
		}
	}
}
