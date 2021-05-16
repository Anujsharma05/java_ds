package loops;

import java.util.Scanner;

public class NumberPallindrome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int reverse = 0;
		
		int temp = num;
		while(temp > 0) {
			int r = temp % 10;
			
			reverse = reverse*10 + r;
			temp /= 10;
		}
		System.err.println("Pallindrome? : " + (num == reverse));
	}

}
