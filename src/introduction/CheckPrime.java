package introduction;

public class CheckPrime {

	public static void main(String[] args) {
		
		for(int i=1; i<60; i++) {
			System.out.println(i + " = " + primeChecker(i));
		}
	}
	
	private static boolean primeChecker(int num) {
		
		if(num<=1) {
			return false;
		}
		
		int c = 2;
		
		while(c*c <= num) {
			if(num%c == 0) {
				return false;
			}
			c++;
		}
		
		return true;
	}

}
