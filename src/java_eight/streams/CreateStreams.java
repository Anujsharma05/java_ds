package java_eight.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreams {

  public static void main(String[] args) {

    /**
     * Empty Stream
     */
    Stream<Integer> st = Stream.empty();

//    arrayStream();
//    primitiveStreamMethods();
//    primitiveStreamSummaryStatistics();
//    infiniteStream();
    optional();
  }

  static void arrayStream() {
    double[] values = {1,2,3,4,5};
    /**
     * FOR PRIMITIVES
     * Arrays.stream(arr) => for int,long,double arrays
     * IntStream - for int,byte,short,char
     * DoubleStream - for double,float
     * LongStream - for long
     *
     * DoubleStream.of(1.1,2.1,3.1)
     */
    DoubleStream doubleStream = Arrays.stream(values);
    doubleStream = DoubleStream.of(values);
    System.out.println(doubleStream.count());
  }

  /**
   * min(), max(), average(), sum()
   */
  static void primitiveStreamMethods() {

    IntStream intStream = Stream.of(1,2,3).mapToInt(n -> n.intValue());
    intStream = IntStream.of(1,2,3);

    int sum = intStream.sum();
    System.out.println(sum);

    intStream = IntStream.of(1,2,3);
    OptionalDouble optionalDouble = intStream.average();
    System.out.println(optionalDouble.getAsDouble());
  }

  static void primitiveStreamSummaryStatistics() {
    IntStream intStream = IntStream.of(1,2,3);
    IntSummaryStatistics intStats = intStream.summaryStatistics();
    long sum = intStats.getSum();
    int min = intStats.getMin();
    System.out.println("min: " + min + ", sum: " + sum);

    IntStream intStream1 = IntStream.empty();
    IntSummaryStatistics emptyStats = intStream1.summaryStatistics();
    System.out.println(emptyStats.getSum());
    System.out.println(emptyStats.getMin());
    System.out.println(emptyStats.getAverage());
  }

  static void infiniteStream() {
    Stream<Integer> infiniteStream1 = Stream.generate(() -> (int) (Math.random() * 10));
    Stream<Integer> infiniteStream2 = Stream.iterate(2, n -> n+2);
    infiniteStream1.limit(10).forEach(System.out::println);
    infiniteStream2.limit(10).forEach(System.out::print);
  }

  static void optional() {
    String s = null;
    Optional<String> op = Optional.ofNullable(s);
    System.out.println(op);

    /**
     * Primitive
     */
    OptionalDouble averageOptional = IntStream.rangeClosed(1,10).average();
    averageOptional.ifPresent(avg -> System.out.println("Average:" + avg));
    System.out.println("Average if present return value otherwise default value provided in args" + averageOptional.orElse(Double.NaN));
  }
}
