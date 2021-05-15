package loops;

import java.util.Scanner;

public class XPowery {

	public static void main(String[] args) {
		
		int result = 1;
		Scanner sc = new Scanner(System.in);
		System.err.println("enter base number");
		int x = sc.nextInt();
		System.err.println("enter power");
		int y = sc.nextInt();
		sc.close();
//		System.err.println((int)Math.pow(x, y));
		
		for(int i = 0 ; i < y ; i++) {
			result = result * x;
		}
		
		System.err.println(result);
	}

}
