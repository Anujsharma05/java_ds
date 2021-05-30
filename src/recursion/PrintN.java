package recursion;

public class PrintN {

	static int i = 1;
	
	public static void main(String[] args) {

		int n = 10;
		
		printNos(n);
	}

	private static void printNos(int n) {
		
		if(i<=n) {
			System.err.print(i + " ");
			i++;
			print(n);
		}
	}
	
	private static void print(int n) {
		if(i<=n) {
			System.err.print(i + " ");
			i++;
			printNos(n);
		}
	}
}

