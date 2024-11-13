package java_eight.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

  public static void main(String[] args) {
//    reduceWithIdentity();
//    reduceWithoutIdentity();
    reduceWithBiFunction();
//    collect();
//    collectUsingCollectors();
//    collectMap();
//    groupingBy();
//    partioningBy();
  }

  /**
   * With identity version of reduce does not return Optional value because
   * even if the operation results in null, the output will be the identity
   */
  static void reduceWithIdentity() {
    Stream<String> stringStream = Stream.of("a", "n", "u", "j");
    String output = stringStream.reduce("", (p, up) -> p + up);
    System.out.println(output);

    Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
    int multiply = intStream.reduce(1, (p, up) -> p * up);
    System.out.println(multiply);
  }

  /**
   * It returns Optional because there is no identity value,
   * so it is possible to get null as value
   */
  static void reduceWithoutIdentity() {
    Stream<Integer> intStream = Stream.of(1, 2, 3);
    Optional<Integer> integerOptional = intStream.reduce((a, b) -> a);
    integerOptional.ifPresent(System.out::println);
  }

  /**
   * This can be used to process complex objects
   * Accumulator adds an element to the collection.
   * Combiner combines two collections.
   * This is useful in parallel processing
   */
  static void reduceWithBiFunction() {
    Stream<String> stringStream = Stream.of("car", "bus", "bike");
    int totalLength = stringStream.reduce(0, (n, str) -> n + str.length(), (n1, n2) -> n1 + n2);
    System.out.println(totalLength);
  }

  /**
   * Accumulator adds an element to the collection.
   * Combiner combines two collections.
   * This is useful in parallel processing
   */
  static void collect() {
    Stream<String> stringStream = Stream.of("this", " ", "is", " ", "sparta");

    StringBuilder output = stringStream.collect(() -> new StringBuilder(),
        (sb, str) -> sb.append(str), (sb1, sb2) -> sb1.append(sb2));

    System.out.println(output);
  }

  static void collectUsingCollectors() {
    Stream<String> stringStream = Stream.of("apple", "banana", "mango");
    String result = stringStream.collect(Collectors.joining(","));
    System.out.println(result);

    Stream<Integer> integerStream = Stream.of(10, 20, 30);
    Double avg = integerStream.collect(Collectors.averagingInt(num -> num));
    System.out.println(avg);
  }

  static void collectMap() {
    Stream<String> stringStream = Stream.of("car", "bus", "bike");

    /**
     * Merge function: (str1, str2) -> str1 + "," + str2) is used below to combine the values if duplicate key is found
     * Last argument decides which type of map implementation you want hashmap or treemap etc
     */
    HashMap<Integer, String> mapHandlingDuplicateKey = stringStream.collect(
        Collectors.toMap(str -> str.length(), str -> str, (str1, str2) -> str1 + "," + str2, () -> new HashMap<>()));

    mapHandlingDuplicateKey.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));
  }

  static void groupingBy() {
    Stream<String> stringStream = Stream.of("car", "truck", "bike", "car", "bus");
    Map<Integer, List<String>> map = stringStream.collect(Collectors.groupingBy(str -> str.length()));
    System.out.println(map);

    /**
     * Using set implementation
     */
    Stream<String> stringStream2 = Stream.of("car", "truck", "bike", "car", "bus");
    Map<Integer, Set<String>> map2 = stringStream2
        .collect(Collectors.groupingBy(
            str -> str.length()
            , Collectors.toSet() //downstream collector -> what to do with the values
        ));
    System.out.println(map2);

    Stream<String> stringStream3 = Stream.of("car", "truck", "bike", "car", "bus");
    HashMap<Integer, Set<String>> map3 = stringStream3
        .collect(Collectors.groupingBy(
            str -> str.length()
            , () -> new HashMap<>() // map type supplier -> what type of map you want
            , Collectors.toSet() //downstream collector -> what to do with the values
        ));
    System.out.println(map3);
  }

  static void partioningBy() {
    Stream<String> stringStream = Stream.of("luffy", "zoro", "sanji", "chopper", "usopp");
    Map<Boolean, List<String>> map = stringStream.collect(Collectors.partitioningBy(str -> str.startsWith("z") || str.startsWith("s")));
    System.out.println(map);

    /**
     * here also we can provide a downstream collector such as Set instead of List
     */
    Stream<String> stringStream2 = Stream.of("luffy", "zoro", "sanji", "chopper", "usopp", "usopp");
    Map<Boolean, Set<String>> map2 = stringStream2
        .collect(Collectors.partitioningBy(str -> str.startsWith("z") || str.startsWith("s"), Collectors.toSet()));

    System.out.println(map2);
  }
}
