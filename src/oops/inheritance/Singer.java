package oops.inheritance;

import oops.inheritance.person.Person;

public class Singer extends Person{

	public Singer() {
		super();
	}
	public Singer(String name) {
		super(name);
	}

	@Override
	public void walk() {
		System.out.println(name + " is walking slowly");
	}

	public final void sing() {
		System.err.println(name + " is singing");
	}

//	@Override
	public static void demo() {
		System.out.println("greeting in singer");
	}
}
