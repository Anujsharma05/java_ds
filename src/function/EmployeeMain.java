package function;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeMain {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<>();
		populate(list);
//		totalMonthlySalary(list);
		salaryIncrement(list);
	}
	

	private static void salaryIncrement(ArrayList<Employee> list) {
		
		Predicate<Employee> p = emp -> emp.salary < 3500;
		
		Function<Employee, Employee> fn = emp -> {
			emp.salary = emp.salary + 447;
			return emp;
		};
		
		for(Employee emp: list) {
			if(p.test(emp)) {
				fn.apply(emp);
			}
		}
		
		System.out.println(list);
		
		
		
	}


	private static void totalMonthlySalary(ArrayList<Employee> list) {
		Function<ArrayList<Employee>, Double> fn = empList -> {
			double sum = 0;
			for(Employee e: empList) {
				sum += e.salary;
			}
			return sum;
		};
		
		System.out.println(fn.apply(list));
	}


	static void populate(ArrayList<Employee> list) {
		list.add(new Employee("Student1", 1000));
		list.add(new Employee("Student2", 2000));
		list.add(new Employee("Student3", 3000));
		list.add(new Employee("Student4", 4000));
		list.add(new Employee("Student5", 5000));
	}
}
