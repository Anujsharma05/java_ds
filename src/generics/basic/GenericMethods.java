package generics.basic;

import java.util.Arrays;

public class GenericMethods {
    public <T> void method1(T item) {}
    public <T,V> void method2(T t, V v) {
        System.out.println(t + "," + v);
    }
    public <T> void method3(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        GenericMethods obj = new GenericMethods();
        obj.method2(2, 4);

        /**
         * Compile time error, no primitive allowed, only Object type allowed
         */
//        int[] arr = {1,2,3};
        Integer[] arr = {1,2,3};
        obj.method3(arr);
    }
}
