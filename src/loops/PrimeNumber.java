package loops;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.err.println("Enter number to check whether it is prime or not");
		int num = sc.nextInt();
		sc.close();
		boolean isPrime = true;
		
		if(num < 2) {
			isPrime = false;
		} else {
			for(int i = 2 ; i * i <= num ; i++) {
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		System.err.println("Is Prime " + isPrime);
	}
}
