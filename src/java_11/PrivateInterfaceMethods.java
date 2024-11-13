package java_11;

interface One {
  default void methodOne() {
    System.out.println("method one");
    hello();
  }

  private void hello() {
    System.out.println("hello");
  }
}

class OneClass implements One {
  @Override
  public void methodOne() {
//    One.super.methodOne();
    System.out.println("method one class");
  }
}
public class PrivateInterfaceMethods {

  public static void main(String[] args) {
    One one = new OneClass();
    one.methodOne();
  }
}
