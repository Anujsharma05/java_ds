package loops;

import java.util.Scanner;

public class SeriesSum {

	public static void main(String[] args) {
		
		float result = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		for(float i = 1 ; i <= n ; i++) {
			if(i % 2 == 0) {
				result -= 1/i;
			} else {
				result += 1/i;
			}
		}
		
		System.err.println(result);
	}

}
