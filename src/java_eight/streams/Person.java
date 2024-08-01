package java_eight.streams;

import java.util.ArrayList;
import java.util.List;

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

  public static List<Person> getPeople() {
    List<Person> result = new ArrayList<>();
    result.add(new Person("Mike", 33, 1.8));
    result.add(new Person("Mary", 25, 1.4));
    result.add(new Person("Alan", 34, 1.7));
    result.add(new Person("Zoe", 30, 1.5));
    return result;
  }
}
