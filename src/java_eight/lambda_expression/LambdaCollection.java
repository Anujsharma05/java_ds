package java_eight.lambda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

class MyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
		return i1 - i2;
	}
}

class Employee implements Comparable<Employee>{
	int eno;
	String ename;
	
	public Employee(int eno, String ename) {
		this.eno = eno;
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.ename.compareTo(o.ename);
	}
}
public class LambdaCollection {
	public static void main(String args[]) {
		
		Employee tanjiro = new Employee(12, "Tanjiro");
		Employee zenitsu = new Employee(10, "Zenitsu");
		Employee inosuke = new Employee(3, "Inosuke");
		
		List<Employee> elist = new ArrayList<>();
		elist.add(tanjiro);
		elist.add(zenitsu);
		elist.add(inosuke);
		Collections.sort(elist);
		System.out.println(elist);
//		Collections.sort(elist, (o1, o2) -> o1.ename.compareTo(o2.ename));
//		System.out.println(elist);
		
		
		//integer natural order asc
		//string natural order alphabetical
		
//		sortList();
//		sortTreeSetDesc();
//		sortTreeMapDesc();
	}
	
	static void sortList() {
		
		List<Integer> list = Arrays.asList(4,5,1,7,3,2,6,2,1);
//		Comparator<Integer> comp = new MyComparator();
		
		Comparator<Integer> comp = (i1, i2) -> i1 - i2;
				
		Collections.sort(list, comp);
		
		System.out.println(list);
	}
	
	static void sortTreeSetDesc() {
		//passed comparator to the constructor
		TreeSet<Integer> ts = new TreeSet<>((i1, i2) -> i2 - i1);
		ts.add(4);
		ts.add(1);
		ts.add(6);
		ts.add(9);
		ts.add(8);
		ts.add(3);
		
		System.out.println(ts);
	}
	
	static void sortTreeMapDesc() {
		
		TreeMap<Integer, String> tm = new TreeMap<>((i1, i2) -> i2 - i1);
		tm.put(44, "aac");
		tm.put(33, "bac");
		tm.put(77, "bab");
		tm.put(22, "aab");
		tm.put(11, "cab");
		tm.put(66, "caa");
		
		System.out.println(tm);
	}
}
