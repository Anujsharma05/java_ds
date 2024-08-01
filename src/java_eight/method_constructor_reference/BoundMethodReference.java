package java_eight.method_constructor_reference;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Bound method references are associated with a specific instance
 * In below examples, instance is String object: name;
 */
public class BoundMethodReference {
  public static void main(String[] args) {

    String name = "Mr. Sanji";

    Supplier<String> supplierWithLambda = () -> name.toUpperCase();
    Supplier<String> supplierWithMethodRef = name::toUpperCase;

    System.out.println(supplierWithLambda.get());
    System.out.println(supplierWithMethodRef.get());

    Predicate<String> predicateWithLambda = (prefix) -> name.startsWith(prefix);
    Predicate<String> predicateWithMethodRef = name::startsWith;

    System.out.println(predicateWithLambda.test("Mr."));
    System.out.println(predicateWithMethodRef.test("Ms."));
  }
}
