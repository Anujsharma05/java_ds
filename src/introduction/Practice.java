package introduction;

public class Practice {

	private class Hello {
		int a;
		int b;
	}
	
	public static void main(String[] args) {
		
		Practice obj = new Practice();
		obj.testMethod();
		
//		won't work because no object of parnent is created
//		Hello o = new Hello();
		
		{
			int c = 12;
		}
		int c = 44;
	}

	private void testMethod() {
		Hello obj = new Hello();
		obj.a = 12;
		obj.b = 11;
		System.out.println(obj.hashCode());
		changeName(obj);
	}

	private static void changeName(Hello obj) {
		System.out.println(obj.hashCode());
		obj.a = 33;
		obj.b  = 54;
	}

}
