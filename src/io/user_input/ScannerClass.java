package io.user_input;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		
		System.err.println("enter a number");
		Scanner sc = new Scanner(System.in);
//		System.err.println(args[0]);
		int x = sc.nextInt();
		System.err.println("enter a string");

		//string 'b' will be empty because when we hit enter after entering int x then the enter symbol is taken as string input in str automatically
//		sc.nextLine();	// to accomodate enter symbol
		String b = sc.nextLine();
		System.err.println(x + ":" + b);
		sc.close();
	}

}
