package conditional;

import java.util.Scanner;

public class SwitchCalculator {

	public static void main(String[] args) {
		
		float a, b;
		
		Scanner sc = new Scanner(System.in);
		
		System.err.println("Enter first number");
		a = sc.nextFloat();
		
		System.err.println("Enter second number");
		b = sc.nextFloat();
		
		System.err.println("Enter operation");
		sc.nextLine();
		char operation = sc.nextLine().charAt(0);
		sc.close();
		float result = 0;
		
		switch(operation) {
		case '+':
			result = a + b;
			break;
		case '-':
			result = a - b;
			break;
		case '*':
			result = a * b;
			break;
		case '/':
			result = a / b;
			break;
		default:
			System.err.println("Unsupported Operation");
		}
		
		System.err.println("Result: " + result);

	}

}
