package oops.inheritance;

import oops.inheritance.person.Person;

public class Singer extends Person{
	
	public Singer(String name) {
		super(name);
	}

	public void sing() {
		System.err.println(name + " is singing");
	}
}
