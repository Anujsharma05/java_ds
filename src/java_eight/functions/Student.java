package java_eight.functions;

public class Student {
	String name;
	int marks;
	
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %d", name, marks);
	}

}
