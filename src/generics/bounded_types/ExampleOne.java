package generics.bounded_types;

import java.io.Serializable;
import java.util.ArrayList;

public class ExampleOne {
    public static <T extends Comparable<T>> T method1(T v1, T v2) {
        /**
         * Due to bounded type, we are able to invoke Comparable's "compareTo" method
         */
        if(v1.compareTo(v2) < 0) {
            return v1;
        } else {
            return v2;
        }
    }
    public static void main(String[] args) {
        int i1 = 3;
        int i2 = 5;
        int smaller = method1(i1, i2);
        System.out.println(smaller);

        String s1 = "inosuke";
        String s2 = "tanjiro";
        String s = method1(s1, s2);
        System.out.println(s);

        /**
         * We cannot use T in the main method
         */
//        List<T> f = new ArrayList<String>();
    }
}
