package introduction;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		
		System.err.println(x);
		sc.close();
	}

}
