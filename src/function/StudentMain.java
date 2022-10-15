package function;

import java.util.function.Function;
import java.util.ArrayList;

public class StudentMain {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		populate(list);
		
		printGrades(list);
	}
	

	private static void printGrades(ArrayList<Student> list) {
		
		Function<Student, String> fn = st -> {
			int marks = st.marks;
			
			if(marks >= 80) return "A";
			else if(marks >= 60) return "B";
			else if(marks >= 40) return "C";
			else return "D";
		};
		
		list.forEach(st -> System.out.println(fn.apply(st)));
	}


	static void populate(ArrayList<Student> list) {
		list.add(new Student("Student1", 55));
		list.add(new Student("Student2", 65));
		list.add(new Student("Student3", 75));
		list.add(new Student("Student4", 90));
		list.add(new Student("Student5", 45));
		list.add(new Student("Student6", 35));
		list.add(new Student("Student7", 25));
	}
}
