package java_eight.functions;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class EmployeeMain {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<>();
		populate(list);
//		totalMonthlySalary(list);
		salaryIncrement(list);
	}

	private static void salaryIncrement(ArrayList<Employee> list) {

		Predicate<Employee> p = emp -> emp.salary < 3500;

		UnaryOperator<Employee> fn = emp -> {
			emp.salary = emp.salary + 447;
			return emp;
		};

		for (Employee emp : list) {
			if (p.test(emp)) {
				fn.apply(emp);
			}
		}

		System.out.println(list);

	}

	private static void totalMonthlySalary(ArrayList<Employee> list) {
		ToDoubleFunction<ArrayList<Employee>> fn = empList -> {
			double sum = 0;
			for (Employee e : empList) {
				sum += e.salary;
			}
			return sum;
		};

		System.out.println(fn.applyAsDouble(list));
	}

	static void populate(ArrayList<Employee> list) {
		list.add(new Employee("Student1", 1000));
		list.add(new Employee("Student2", 2000));
		list.add(new Employee("Student3", 3000));
		list.add(new Employee("Student4", 4000));
		list.add(new Employee("Student5", 5000));
	}
}
