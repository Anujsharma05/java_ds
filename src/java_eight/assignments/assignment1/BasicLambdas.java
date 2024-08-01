package java_eight.assignments.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {
  public static void main(String[] args) {
    sortAge(getPeople());
  }

  static void consumer() {
    Printable<String> printString = str -> System.out.println(str);
    printString.print("Printable lambda");

    Consumer<String> stringConsumer = str -> System.out.println(str);
    Consumer<String> stringConsumerMethodRef = System.out::println;

    stringConsumer.accept("Printable lambda");
    stringConsumerMethodRef.accept("Printable lambda");
  }

  static void supplier() {
    Retrievable<Integer> integerRetrievable = () -> 77;
    Supplier<Integer> integerSupplier = () -> 77;

    System.out.println(integerRetrievable.retrieve());
    System.out.println(integerSupplier.get());
  }

  static void predicate() {
    Evaluate<Integer> isNegative = num -> num < 0;
    System.out.println(isNegative.isNegative(-1));
    System.out.println(isNegative.isNegative(1));

    Predicate<Integer> isNegativePredicate = num -> num < 0;
    System.out.println(isNegativePredicate.test(-1));
    System.out.println(isNegativePredicate.test(1));

    Predicate<Integer> checkEven = num -> num % 2 == 0;
    System.out.println(check(7, checkEven));
    System.out.println(check(4, checkEven));

    Predicate<String> checkPrefix = str -> str.startsWith("Mr.");
    System.out.println(check("Mr. Joe Bloggs", checkPrefix));
    System.out.println(check("Ms. Ann Bloggs", checkPrefix));

    Person mike = new Person( "Mike", 33, 1.8);
    Person ann = new Person( "Ann", 13, 1.4);
    Predicate<Person> isAdult = person -> person.getAge() >= 18;
    System.out.println(check(mike, isAdult));
    System.out.println(check(ann, isAdult));
  }

  static <T> boolean check(T t, Predicate<T> predicate) {
    return predicate.test(t);
  }

  static void function() {
    Functionable<Integer, String> concat = num -> "Number is: " + num;
    System.out.println(concat.applyThis(25));

    Function<Integer, String> function = num -> "Number is: " + num;
    System.out.println(function.apply(25));
  }

  private static List<Person> getPeople() {
    List<Person> result = new ArrayList<>();
    result.add(new Person("Mike", 33, 1.8));
    result.add(new Person("Mary", 25, 1.4));
    result.add(new Person("Alan", 34, 1.7));
    result.add(new Person("Zoe", 30, 1.5));
    return result;
  }

  private static void sortAge(List<Person> listPeople) {
    listPeople.sort(Comparator.comparing(Person::getAge));
    listPeople.forEach(System.out::println);
  }

  private static void sortName(List<Person> listPeople) {
    listPeople.sort(Comparator.comparing(Person::getName));
    listPeople.forEach(System.out::println);
  }

  private static void sortHeight(List<Person> listPeople) {
    listPeople.sort(Comparator.comparing(Person::getHeight));
    listPeople.forEach(System.out::println);
  }
}
