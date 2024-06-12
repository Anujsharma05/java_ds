package generics.old_examples;

interface GenericInterface<T> {
    void genericMethod(T value);
}

public class GenericInterfaceExample implements GenericInterface<Integer>{

    @Override
    public void genericMethod(Integer value) {
        System.out.println("value is " + value);
    }

    public static void main(String[] args) {
        GenericInterface<Integer> gi = new GenericInterfaceExample();
        gi.genericMethod(4);
    }
}
