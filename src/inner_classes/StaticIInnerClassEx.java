package inner_classes;

public class StaticIInnerClassEx {

	static int num = 33;
	int age;

	static class Inner {
		void hello() {
			System.out.println("hello: " + num);
			num = 3;
			System.out.println(num);

			StaticIInnerClassEx outerObj = new StaticIInnerClassEx();
			outerObj.age = 55;
		}

		static void hi() {
			System.out.println("hi");
			num = 22;
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		Inner i = new Inner();
		i.hello();
		Inner.hi();
	}
}
