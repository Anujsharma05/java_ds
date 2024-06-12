package generics.bounded_types;

import java.io.Serializable;

public class MultipleBounds {

    public static <T extends Number & Serializable> void show(T t) {
        System.out.println(t);
    }
    public static void main(String[] args) {
        int i = 4;
        show(i);
    }
}
