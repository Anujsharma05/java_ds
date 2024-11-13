package useful_concepts;

import java.util.HashSet;

class Employee {
  int id;
  String name;

  public Employee(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public int hashCode() {
//    final int prime = 31;
//    int result = 1;
//    result = prime * result + id;
//    result = prime * result
//        + ((name == null) ? 0 : name.hashCode());
//    return result;
    return this.id;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null || obj.getClass() != this.getClass()) return false;

    if(this == obj) return true;

    Employee emp = (Employee) obj;

    if(this.id != emp.id) return false;
    if(!this.name.equals(emp.name)) return false;

    return true;
  }
}

public class SetEqualsHashcode {

  public static void main(String[] args) {
    HashSet<Employee> set = new HashSet<>();
    set.add(new Employee(101, "Anuj"));
    System.out.println(set.add(new Employee(101, "Anuj")));


  }
}
