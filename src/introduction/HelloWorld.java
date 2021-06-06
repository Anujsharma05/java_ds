package introduction;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		long l = 13;
		float f = l;
		
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		
		System.err.println(x);
		sc.close();
	}

}
