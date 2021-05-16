package advanced_patterns;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int count = 1;
		for(int i = 1 ; i<=n ; i++) {
			for(int j = 1 ; j <= (n - i); j++) {
				System.err.print("  ");
			}
			
			for(int j = 1 ; j<=i ; j++) {
				System.err.print(" " + count + "  " );
				count += 1;
			}
			
			System.err.println();
		}
	}

}
