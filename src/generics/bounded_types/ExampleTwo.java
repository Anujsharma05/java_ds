package generics.bounded_types;

interface Interf<T> {
    void method1(T t);
}

class ImplementingClass implements Interf<ImplementingClass> {

    public String val;
    @Override
    public void method1(ImplementingClass implementingClass) {
        System.out.println("string: " + implementingClass.val);
    }
}

/**
 * Need to understand this topic better
 */
public class ExampleTwo {

    public <T extends Interf<T>> void test(T t) {
        t.method1(t);
    }
    public static void main(String[] args) {
        ExampleTwo obj = new ExampleTwo();
        ImplementingClass ic = new ImplementingClass();
        ic.val = "anuj";
        obj.test(ic);
    }
}
