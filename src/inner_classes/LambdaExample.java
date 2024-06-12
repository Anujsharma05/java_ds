package inner_classes;

@FunctionalInterface
interface Interf {
	void hi();
}

public class LambdaExample {
	static int age;

	public static void main(String argsp[]) {

		float b1 = 3, b2 = 1;
		double d = b1 * b2;

		int n;
		Interf i = () -> {
			int num = 3;
			age = num;
		};
	}
}