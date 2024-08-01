package java_17;

sealed interface Driveable permits Vehicle {
  default void drive() {
    System.out.println("driving");
  };
}

sealed class Vehicle implements Driveable permits Car {}

sealed class Car extends Vehicle permits Ford, Volvo{}

non-sealed class Ford extends Car {}

final class Volvo extends Car {}

class Mustang extends Ford {}

public class SealedClasses {
  public static void main(String[] args) {
    Volvo volvo = new Volvo();
    volvo.drive();

    Mustang mustang = new Mustang();
    mustang.drive();
  }
}
