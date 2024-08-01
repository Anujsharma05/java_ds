package reflection.section2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * getDeclaredConstructors: return all constructors in current class only
 * getConstructors: returns only public constructors along with super class
 */
public class ConstructorInfoAndObjectCreation {

  public static void main(String[] args)
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
//        printConstructorData(Person.class);
        createNewInstanceObject();
  }

  private static void createNewInstanceObject()
      throws InvocationTargetException, InstantiationException, IllegalAccessException {

    /**
     * Create object without arguments
     */
    Person person1 = createInstanceWithArguments(Person.class);
    System.out.println(person1);

    /**
     * Create object with arguments
     */
    Address address = createInstanceWithArguments(Address.class, "Grand line", 60);
    Person person2 = createInstanceWithArguments(Person.class, "Zoro", 28, address);
    System.out.println(person2);
  }

  private static void printConstructorData(Class<?> input) {

    Constructor<?>[] constructors = input.getDeclaredConstructors();

    System.out.println(String.format("%s class has %d declared constructors",
        input.getSimpleName(), constructors.length));

    for (int i = 0; i < constructors.length; i++) {
      Class<?>[] parameterTypes = constructors[i].getParameterTypes();

      List<String> parameterTypeNames = Arrays.stream(parameterTypes)
          .map(classType -> classType.getSimpleName())
          .collect(Collectors.toList());

      System.out.println(parameterTypeNames);
    }
  }

  /**
   * Create new object of given class and corresponding arguments in right order
   */
  private static <T> T createInstanceWithArguments(Class<T> clazz, Object... args)
      throws InvocationTargetException, InstantiationException, IllegalAccessException {
    Constructor<?>[] constructors = clazz.getDeclaredConstructors();
    for (Constructor<?> constructor : constructors) {
      if (constructor.getParameterTypes().length == args.length) {
        /**
         * To create new instance
         */
        return (T) constructor.newInstance(args);
      }
    }
    System.out.println("An appropriate constructor was not found");
    return null;
  }

  public static class Person {

    private final Address address;
    private final String name;
    private final int age;

    public Person() {
      this.name = "anonymous";
      this.age = 0;
      this.address = null;
    }

    public Person(String name) {
      this.name = name;
      this.age = 0;
      this.address = null;
    }

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
      this.address = null;
    }

    public Person(String name, int age, Address address) {
      this.name = name;
      this.age = age;
      this.address = address;
    }

    @Override
    public String toString() {
      return "Person{" +
          "address=" + address +
          ", name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

  public static class Address {

    private String street;
    private int number;

    public Address(String street, int number) {
      this.street = street;
      this.number = number;
    }

    @Override
    public String toString() {
      return "Address{" +
          "street='" + street + '\'' +
          ", number=" + number +
          '}';
    }
  }
}
