package conditional;

public class NestedIfElse {
	public static void main(String[] args) {
		
		int a = 15 ; int b = 27; int c = 23;
		int d = 34;
		int greatest = 0;
		
//		if(a > b) {
//			if( a > c) {
//				greatest = a;
//			} else {
//				greatest = c;
//			}
//		} else {
//			if(b > c) {
//				greatest = b;
//			} else {
//				greatest = c;
//			}
//		}
//		greatest = a > b ? (a > c ? a : c) : (b > c ? b : c);
		int x = (a > b ? a : b);
		int y = (c > d ? c : d);
		greatest = x > y ? x : y;
		System.err.println("Greatest: " + greatest);
	}
}
