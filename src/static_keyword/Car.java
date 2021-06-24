package static_keyword;

class OuterClass {
	  int x = 10;

	  private class InnerClass {
	    int y = 5;
	  }
	  
	  public void display() {
	  	InnerClass obj = new InnerClass();
	    System.out.println("abcefg=" + obj.y);
	}
}

class Outer {
	public static void myMethod() {
//		static int abc = 32;
	}
	   void outerMethod() {
	      int x = 98;
	      System.out.println("inside outerMethod");
	      class Inner {
	         void innerMethod() {
	            System.out.println("x= "+x);
	         }
	      }
	      Inner y = new Inner();
	      y.innerMethod();
	   }
	}

public class Car {

	String name;
	static int numberOfCars;
	
	public Car(String name) {
		this.name = name;
		numberOfCars++;
//		OuterClass obj = new OuterClass();
//		obj.display();
		Outer obj = new Outer();
		obj.outerMethod();
	}
	
	
}
