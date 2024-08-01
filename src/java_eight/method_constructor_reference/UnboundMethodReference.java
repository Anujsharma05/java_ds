package java_eight.method_constructor_reference;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * An unbound method reference is not tied to any specific instance
 * Here String::toUpperCase is not tied to any specific String object
 * Also, String::concat is not tied to any specific String object
 *
 * The compiler infer the method reference arguments based on the calling arguments
 *
 * Static method references are considered unbound method references
 */
public class UnboundMethodReference {
  public static void main(String[] args) {

    Function<String, String> functionWithLambda = (name) -> name.toUpperCase();
    Function<String, String> functionWithMethodRef = String::toUpperCase;
    System.out.println(functionWithLambda.apply("Anuj"));
    System.out.println(functionWithMethodRef.apply("Anuj"));

    BinaryOperator<String> binaryOperatorWithLambda = (s1, s2) -> s1.concat(s2);
    BinaryOperator<String> binaryOperatorWithMethodRef = String::concat;
    System.out.println(binaryOperatorWithLambda.apply("Anuj", "Sharma"));
    System.out.println(binaryOperatorWithMethodRef.apply("Anuj", "Sharma"));
  }
}
