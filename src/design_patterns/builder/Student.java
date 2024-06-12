package design_patterns.builder;

public class Student {

	// mandatory
	private String name;
	private String email;
	// optional
	private String address;
	private int age;

	private Student(StudentBuilder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.address = builder.address;
		this.age = builder.age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", address=" + address + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public static class StudentBuilder {

		private String name;
		private String email;
		private String address;
		private int age;

		public StudentBuilder(String name, String email) {
			this.name = name;
			this.email = email;
		}

		public StudentBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public StudentBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public Student build() {
			return new Student(this);
		}

	}
}
