package oops.inheritance.main;

class Base {
	private int x;
	public Base(int x) {
		this.x = x;
		System.err.println("base constructor");
	}
	public void display() {
		System.err.println("base class display");
	}
}

class Derived extends Base{
	int y;
	public Derived(int y) {
		super(y);
		this.y = y;
		System.err.println("derived constructor");
	}
	
	public void show() {
		System.err.println("derived class show ");
	}
}

class Animal {
	void eat() {
		System.err.println("animal is eating");
	}
	void show() {
		System.err.println("afdsadf");
	}
}

class Deer extends Animal {
	void eat() {
		System.err.println("Deer is eating grass");
	}
	void hello() {
		System.err.println("hello deer");
	}
}

class Fawn extends Deer {
	void eat() {
		System.err.println("eating on mother's feed");
	}
	void pickUpTheFawn() {
		System.err.println("please pick up the fawn");
	}
}

public class Test {

	public static void main(String[] args) {
		
		Animal animal = new Fawn();
		animal.eat();
		animal.show();
		
		Deer deer =new Fawn();
		deer.eat();
	}

}
