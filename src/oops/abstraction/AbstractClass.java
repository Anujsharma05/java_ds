package oops.abstraction;

abstract class Base {
	abstract void show();
	
	void display() {
		System.err.println("non abstract methods");
	}
}

abstract class Derived extends Base {
	
}

class DerivedFromDerived extends Derived{
	void show() {
		System.err.println("derived from derived show");
	}
	void paint() {
		System.err.println("painting the wall");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		
		Base obj = new DerivedFromDerived();
		obj.show();
//		obj.paint();	//won't work object slicing
	}

}
