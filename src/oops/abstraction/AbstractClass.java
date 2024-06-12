package oops.abstraction;

class Highest {
	void run() {
		System.out.println("run from hightest class");
	}
}

abstract class Base extends Highest {

	int marks;

	static String name;

	Base(int marks) {
		this.marks = marks;
		name = "Anuj";
	}

//	abstract void show();

	void display() {
		System.err.println("non abstract methods");
	}
}

abstract class Derived extends Base {
	Derived(int marks) {
		super(marks);
		System.out.println("parent constructor");
	}
}

class DerivedFromDerived extends Derived {
	{
		System.out.println("child instance initialization block");
	}

	public DerivedFromDerived(int marks) {
		super(marks);
		System.out.println("constructor of child");
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
