package java_eight.assignments.assignment1;

public class Person {
  private String name;
  private int age;
  private double height;

  public Person( String name, int age, double height) {
    this.age = age;
    this.name = name;
    this.height = height;
  }

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public double getHeight() {
    return height;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", height=" + height +
        '}';
  }
}
