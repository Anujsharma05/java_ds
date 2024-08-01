package java_eight.final_effectively_final;

import java.util.function.Predicate;

/**
 * Lambda take picture/snapshot of local variable value, thus the values
 * of these local variable cannot be changed
 */
public class ExampleOne {
  static int z =3;
  public static void main(String[] args) {

    /**
     * Local variables
     */
    int x = 10;
    final int y = 2;
    Predicate<Integer> IsGreaterThan10 = num -> {
      /**
       * x is Effectively final: as we are not changing the value of x
       * y is final
       */
      num = num + x + y;

      /**
       * Instance variable can be changed
       */
      z++;

      /**
       * This will give compilation error because we are changing x
       */
//      x++;

      return num > 10;
    };

    otherMethod(IsGreaterThan10);
  }

  static void otherMethod(Predicate<Integer> isGreaterThan10) {
    System.out.println(isGreaterThan10.test(3));
    System.out.println(isGreaterThan10.test(-3));
  }
}
