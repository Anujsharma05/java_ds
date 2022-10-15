package oops.abstraction;

class Highest {
	void run() {
		System.out.println("run from hightest class");
	}
}

abstract class Base extends Highest{

	int marks;

	static String name;

	public Base(int marks) {
		this.marks = marks;
		name = "Anuj";
	}

//	abstract void show();
	
	void display() {
		System.err.println("non abstract methods");
	}
}

abstract class Derived extends Base {
	public Derived(int marks) {
		super(marks);
	}
}

class DerivedFromDerived extends Derived{

	public DerivedFromDerived(int marks) {
		super(marks);
	}

	void show() {
		System.err.println("derived from derived show");
	}
	void paint() {
		System.err.println("painting the wall");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		
		Base obj = new DerivedFromDerived(4);
		System.out.println(Base.name);
		obj.marks = 3;
		System.out.println(obj.marks);
//		Base obj = new Base();
		obj.display();
		obj.run();
//		obj.show();
//		obj.paint();	//won't work object slicing
	}

}
