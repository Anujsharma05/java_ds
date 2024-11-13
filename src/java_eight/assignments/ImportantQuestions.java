package java_eight.assignments;

import java.util.Objects;
import java.util.Optional;

public class ImportantQuestions {

  public static void main(String[] args) {
//    differenceBetweenOptionalOrElseAndGet();
//    optionalCodeOptimization();
    objectsUtilityMethods();
    "d".toString();
  }

  public static void optionalCodeOptimization() {
    Optional<String> op = Optional.ofNullable(null);
    op.map(String::toUpperCase).ifPresent(System.out::println);
  }

  public static void objectsUtilityMethods() {

    String s = null;

    boolean a = Objects.isNull(s);
    System.out.println(a);
  }


  /**
   * orElse => It is eager loaded, which means even
   * if optional is present, else value will still be calculated
   *
   * orElseGet =>
   */
  public static void differenceBetweenOptionalOrElseAndGet() {

    /**
     * Else part eagerly calculated
     */
//    Optional<String> op = Optional.of("hello");
//    String res = op.orElse(elseValue());
//    System.out.println(res);

    /**
     * Else part is lazily calculated
     */
    Optional<String> op1 = Optional.of("hello");
    String res = op1.orElseGet(ImportantQuestions::elseValue);
    System.out.println(res);
  }

  public static String elseValue() {
    System.out.println("world printed");
    return "world";
  }
}
