package java_17;

sealed interface SealedIntef permits Hello {
  void hello();
}

record Hello(String name) implements SealedIntef {
  public void hello() {
    System.out.println("Hello " + name);
  }
}

public class SealedInterfaceWithRecord {

  public static void main(String[] args) {
    SealedIntef intef = new Hello("Anuj");
    intef.hello();
  }
}
