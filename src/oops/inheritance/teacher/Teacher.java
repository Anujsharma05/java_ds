package oops.inheritance.teacher;

import oops.inheritance.person.Person;

public class Teacher extends Person {
	
	public Teacher(String name) {
		super(name);
		System.err.println("inside teacher constructor");
	}
	
	public void teach() {
		name = "updated";
		System.err.println(name + " is teaching");
	}
	
	public void walk() {
		System.err.println("teacher is walking");
	}
	
	public static void demo() {
		System.err.println("static method teacher");
	}
	
	public void testing() {
		Person p = new Person("Anuj");
	}
}
