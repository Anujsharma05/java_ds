package introduction;

public class Shadowing {
	static int x = 12;
	int y = 33;

	public static void main(String[] args) {

		System.err.println(x);
		int x = 33;
		System.err.println(x);
		print();
	}

	void hello() {
		System.out.println(y);
		int y = 3;
		System.out.println(y);
	}

	static void print() {
		System.err.println(x);
		int x = 3;
		System.err.println(x);

	}

}
