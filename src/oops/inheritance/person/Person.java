package oops.inheritance.person;

public class Person {

	protected String name;
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	
	public void walk() {
		System.err.println(name + " is walking");
	}
	
	public void eat() {
		System.err.println(name + " is eating");
	}
	
	public static void demo() {
		System.err.println("static method person");
	}
}
