package java_eight.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {

  public static void main(String[] args) {
//    distinct();
//    limit();
//    flatMap();
    sorted();
  }

  /**
   * Stateful operation - remembers the entries that have passed through it
   * It uses equals() to check duplicate
   */
  static void distinct() {
    Stream<String> animals = Stream.of("cat", "cat", "dog", "CAT");
    animals
        .peek(animal -> System.out.println("peek:" + animal))
        .distinct()
        .forEach(animal -> System.out.println("for each:" + animal));
  }

  /**
   * Short circuiting stateful operation
   */
  static void limit() {
      Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7);
      numbers.limit(2).forEach(System.out::println);
  }

  /**
   * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
   * T represents the element type of the original stream.
   * R represents the element type of the new stream.
   * mapper is a function that transforms each element of the original stream into a stream of new values.
   * Flattening is the process of taking out all those items from the lists and putting them into a single collection.
   */
  static void flatMap() {
    List<String> list1 = Arrays.asList("one", "two", "three");
    List<String> list2 = Arrays.asList("four", "five");

    Stream<List<String>> stream = Stream.of(list1, list2);
    stream.flatMap(list -> list.stream()).map(val -> val.toUpperCase()).forEach(System.out::println);
  }

  /**
   * It is a stateful operation as it needs to see all the data before performing the sorting
   */
  static void sorted() {
    List<Person> people = Person.getPeople();
    System.out.println(people);
    people.stream().sorted(Comparator.comparing(person -> person.getAge())).forEach(System.out::println);
  }
}
