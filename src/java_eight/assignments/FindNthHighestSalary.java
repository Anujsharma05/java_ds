package java_eight.assignments;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Student(String name, double salary){}

/**
 * Find all students with 2nd(or nth) highest salary
 */
public class FindNthHighestSalary {

  private static List<Student> students;

  public static void main(String[] args) {
    createData();

    int n = 1;

    List<String> student = findNthHighestSalary(n);
    System.out.println(student);
  }

  static List<String> findNthHighestSalary(int n) {

    if (n < 1 || n > students.size()) {
      return null;
    }

    Map<Double, List<String>> salaryGroup = students.stream()
        .sorted(Comparator.comparingDouble(Student::salary).reversed())
        .collect(Collectors.groupingBy(Student::salary,
            Collectors.mapping(Student::name, Collectors.toList())));

    List<String> s = salaryGroup.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
        .collect(Collectors.toList()).get(n - 1).getValue();

    return s;
  }

  static void createData() {
    Student one = new Student("one", 20000);
    Student two = new Student("two", 10000);
    Student three = new Student("three", 25000);
    Student four = new Student("four", 14000);
    Student five = new Student("five", 50000);
    Student six = new Student("six", 60000);
    Student seven = new Student("seven", 50000);
    Student eight = new Student("eight", 50000);

    students = List.of(one, two, three, four, five, six, seven, eight);
  }
}
