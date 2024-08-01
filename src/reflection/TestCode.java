package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class A {

  int a1;
  protected int a2;
  public int a3;


  public A() {
  }

  A(int a1) {
    this.a1 = a1;
  }

  public void methA() {}
}

class B extends A {

  String b;
  protected String b2;

  public B() {
  }

  public B(String b) {
    this.b = b;
  }
}

class C extends B {

  boolean c;
  protected boolean c2;

  public C(boolean c) {
    this.c = c;
  }

  private static void methC(int c) {
    System.out.println("method C: " + c);
  }
}

public class TestCode {

  public static void main(String[] args) {
    Class<C> c = C.class;
//    constructors(c);
//    fields(c);
    methods(c);
  }

  public static void constructors(Class<?> c) {

    if (c.equals(Object.class)) {
      return;
    }

    Constructor<?>[] constructors = c.getConstructors();
    System.out.println("total constructors: " + constructors.length);
    for (Constructor<?> constructor : constructors) {
      Class<?>[] paramTypes = constructor.getParameterTypes();
      String paramTypeNames = Stream.of(paramTypes).map(paramType -> paramType.getSimpleName())
          .collect(Collectors.joining(","));
      System.out.println(paramTypeNames);
    }

    constructors(c.getSuperclass());
  }

  public static void fields(Class<?> c) {

    Field[] fields = c.getFields();

    for(Field field: fields) {
      System.out.println("Name: " + field.getName());
    }
  }

  public static void methods(Class<?> c) {
    Method[] methods = c.getMethods();

    for(Method method: methods) {
      System.out.println("Name: " + method.getName());
    }

    try {
      Method m = c.getDeclaredMethod("methC", int.class);
      System.out.println(m.getName());
      m.setAccessible(true);
      Object o = m.invoke(null, 5);
      System.out.println(o);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
