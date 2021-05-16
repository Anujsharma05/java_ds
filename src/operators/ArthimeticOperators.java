package operators;

public class ArthimeticOperators {
	public static void main(String[] args) {
		
		int a = 23;
		int b = 45;
		
		int c = a*a + b*b + 2*b*a;
		int d = (a+b) * (a+b);
		
		double quotient = (double)b/(double)a;
		int remainder = b%a;
		
		System.out.println(quotient + " : " + remainder);
		
		System.out.println(c == d);
	}
}
