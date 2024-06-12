package java_eight.functions;

public class Employee {
	String name;
	double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("[%s : %.2f]", name, salary);
	}
}
