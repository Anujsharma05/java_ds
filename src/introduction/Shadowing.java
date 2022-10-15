package introduction;

public class Shadowing {
	static int x = 12;
	public static void main(String[] args) {
		
		{
			System.err.println(x);
			int x = 33;
			System.err.println(x);
		}
		print();
	}
	
	static void print() {
		System.err.println(x);
		int x = 3;
		System.err.println(x);
		
	}

}
