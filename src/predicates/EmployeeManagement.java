package predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeManagement {
	public static void main(String[] args) {
	
		ArrayList<Employee> list = new ArrayList<>();
		populate(list);
//		findManagers(list);
//		cityBangalore(list);
//		giveBonus(list);
//		layOffPinkslip(list);
//		managerOrNeedBonus(list);
//		empNotManagers(list);
		checkObjectEqual(list);
	}
	
	private static void checkObjectEqual(ArrayList<Employee> list) {
		
		Predicate<Employee> zebra = Predicate.isEqual(new Employee("Zebra", "Lead", 22000, "Hydrabad"));
		Employee e = new Employee("Zebra", "Lead", 22000, "Hydrabad");
		System.out.println(zebra.test(e));
		
	}

	private static void findManagers(ArrayList<Employee> list) {
		Predicate<Employee> isManager = emp -> emp.designation.equals("Manager");
		display(isManager, list);
	}
	
	static void cityBangalore(ArrayList<Employee> list) {
		Predicate<Employee> cityBangalore = emp -> emp.city.equals("Bangalore");
		display(cityBangalore, list);
	}
	
	static void giveBonus(ArrayList<Employee> list) {
		Predicate<Employee> isBonusEligible = emp -> emp.salary < 20000;
		display(isBonusEligible, list);
	}
	
	static void layOffPinkslip(ArrayList<Employee> list) {
		Predicate<Employee> cityBangalore = emp -> emp.city.equals("Bangalore");
		Predicate<Employee> isManager = emp -> emp.designation.equals("Manager");
		Predicate<Employee> layOffEmployees = cityBangalore.and(isManager);
		display(layOffEmployees, list);
	}
	
	static void managerOrNeedBonus(ArrayList<Employee> list) {
		Predicate<Employee> isManager = emp -> emp.designation.equals("Manager"); 
		Predicate<Employee> isBonusEligible = emp -> emp.salary < 20000;
		
		Predicate<Employee> managerOrNeedBonus = isBonusEligible.or(isManager);
		display(managerOrNeedBonus, list);
	}
	
	static void empNotManagers(ArrayList<Employee> list) {
		Predicate<Employee> isManager = emp -> emp.designation.equals("Manager"); 
		Predicate<Employee> empNotManagers = isManager.negate();
		display(empNotManagers, list);
	}
	
	static void display(Predicate<Employee> predicate, ArrayList<Employee> list) {
		for(Employee emp: list) {
			if(predicate.test(emp)) {
				System.out.println(emp);
			}
		}
	}

	static void populate(ArrayList<Employee> list) {
		list.add(new Employee("Durga", "CEO", 30000, "Hydrabad"));
		list.add(new Employee("Selmon", "Manager", 25000, "Bangalore"));
		list.add(new Employee("Tiger", "Software Engineer", 15000, "Hydrabad"));
		list.add(new Employee("Lion", "Manager", 25000, "Bangalore"));
		list.add(new Employee("Zebra", "Lead", 22000, "Hydrabad"));
		list.add(new Employee("Giraffe", "Lead", 22000, "Hydrabad"));
		list.add(new Employee("Hippo", "Software Engineer", 15000, "Bangalore"));
	}
}
