package java_eight.bi_predicate_function_consumer;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;

/*
 * BiFunction<T, U, R>
 * 
 * R apply(T t, U u)
 * 
 * andThen()
 */

//example 1
class Student {
	String name;
	int rollno;

	public Student(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}

	@Override
	public String toString() {
		return name + " : " + rollno;
	}
}

//example 2
class Employee {
	int eno;
	String name;
	double dailyWage;

	public Employee(int eno, String name, double dailyWage) {
		super();
		this.eno = eno;
		this.name = name;
		this.dailyWage = dailyWage;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", dailyWage=" + dailyWage + "]";
	}
}

class TimeSheet {
	int eno;
	int days;

	public TimeSheet(int eno, int days) {
		super();
		this.eno = eno;
		this.days = days;
	}

	@Override
	public String toString() {
		return "TimeSheet [eno=" + eno + ", days=" + days + "]";
	}
}

public class BiFunctionExample {

	public static void main(String[] args) {
		basicExample();
//		createStudentObject();
//		employeeMonthlySalary();
	}

	static void basicExample() {
		IntBinaryOperator bifun = (a, b) -> a + b;

		System.out.println(bifun.applyAsInt(4, 5));
		System.out.println(bifun.applyAsInt(14, 15));
	}

	static void createStudentObject() {

		BiFunction<String, Integer, Student> b = Student::new;

		Student s1 = b.apply("anuj", 5);
		Student s2 = b.apply("tanjiro", 3);

		System.out.println(s1);
		System.out.println(s2);
	}

	static void employeeMonthlySalary() {

		BiFunction<Employee, TimeSheet, Double> f = (emp, timesheet) -> {

			BiPredicate<Integer, Integer> p = (eno1, eno2) -> eno1 == eno2;

			if (p.test(emp.eno, timesheet.eno)) {
				return emp.dailyWage * timesheet.days;
			}

			return 0.0;
		};

		Employee e = new Employee(101, "Durga", 1500);
		TimeSheet ts = new TimeSheet(102, 25);

		System.out.println(f.apply(e, ts));
	}

}
