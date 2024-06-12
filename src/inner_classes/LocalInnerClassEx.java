package inner_classes;

public class LocalInnerClassEx {

	int x;
	String y;

	public static void main(String[] args) {
		LocalInnerClassEx obj = new LocalInnerClassEx();
		obj.innerClassMethod();
	}

	void innerClassMethod() {
		class Inner {
			public void hello() {
				x = 3;
				y = "fdafs";
			}
		}

		Inner i = new Inner();
		i.hello();
	}

}
