package inner_classes;

class Third {
	void test() {
		MemberInnerClassEx.Inner i = new MemberInnerClassEx().new Inner();
		i.say();
	}
}

public class MemberInnerClassEx {

	protected class Inner {
		int x;
		void say() {
			System.out.println("say");
		}
	}

	public static void main(String[] args) {

		Inner i = new MemberInnerClassEx().new Inner();
		i.say();
	}
}
