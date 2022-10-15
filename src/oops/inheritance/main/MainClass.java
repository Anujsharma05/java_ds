package oops.inheritance.main;

import oops.inheritance.Singer;
import oops.inheritance.person.Person;
import oops.inheritance.teacher.Teacher;

public class MainClass {

	public static void main(String[] args) {
		Teacher t = new Teacher("Anuj");
//		t.name = " asfasf";
		t.walk();
		t.eat();
		t.teach();
		Teacher.demo();
		
		Person p = t;
		p.walk();
//		Singer s = (Singer)p;
//		p.name = "changed";

	}

}
