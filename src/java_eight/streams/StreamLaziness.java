package java_eight.streams;

import java.util.stream.Stream;

/**
 * Stream's laziness helps with lesser iterations
 */
public class StreamLaziness {
  public static void main(String[] args) {
    Stream<String> stream = Stream.of("A", "B", "C", "D", "E");

    stream
        .peek(val -> System.out.println("peek1: " + val))
        .filter(val -> val.equals("B") || val.equals("D"))
        .peek(val -> System.out.println("peek2: " +val))
        .forEach(val -> System.out.println("For each:" + val));
  }
}
