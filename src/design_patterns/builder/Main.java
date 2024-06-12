package design_patterns.builder;

public class Main {
	public static void main(String[] args) {

		Student student = new Student.StudentBuilder("Anuj", "email").setAge(34).build();
		System.out.println(student);
	}
}
