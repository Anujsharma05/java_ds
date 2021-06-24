package static_keyword;

public class A {
	int outerVar;
	static int abd;
	
	
	
	class B {
		private int y;
		public void display() {
			System.err.println(abd);
			System.err.println(outerVar);
		}
	}
	void helloMethod() {
//		System.err.println("cannot access class B fields"+ y);
	}
	static class C {
		int x;
		static int w;
		public void display() {
			System.err.println(abd);
		}
		
		static class Demo {
			public void testMethod() {
				System.err.println("static within static" + abd);
			}
		}
	}
}
