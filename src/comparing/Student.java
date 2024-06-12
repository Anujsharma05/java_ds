package comparing;

public class Student implements Comparable<Student> {
	int rollNo;
	float marks;

	public int getRollNo() {
		return rollNo;
	}
	public float getMarks() {
		return marks;
	}
	public Student(int rollNo, float marks) {
		this.rollNo = rollNo;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student{" + "rollNo=" + rollNo + ", marks=" + marks + '}';
	}

	@Override
	public boolean equals(Object object) {

		if(this == object) return true;

		if (object == null)
			return false;

		if (object.getClass() != this.getClass())
			return false;

		Student s = (Student) object;

		return this.rollNo == s.rollNo && this.marks == s.marks;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public int compareTo(Student o) {
		return this.rollNo - o.rollNo;
	}
}
