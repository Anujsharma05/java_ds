package java_eight.default_static_methods;

interface Interf {

  static void utilityMethod() {
    System.out.println("utility");
  }
}

class MyClass implements Interf {

}

public class StaticMethodExample {

  public static void main(String args[]) {

    MyClass m = new MyClass();
//		m.utilityMethod();	//won't work
//		MyClass.utilityMethod();	//won't work
    Interf.utilityMethod();
  }
}
