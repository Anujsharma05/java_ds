package generics.wildcards;

import static_keyword.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBounded {
    static void intList(List<? extends Integer> intList) {
        /**
         * Null is the only value that can be added in upper bounded wildcard list
         * This signifies the list is mutable
         */
        intList.add(null);
        System.out.println(intList);
    }
    static void show(List<? extends Number> list) {
        /**
         * We are able to use the bounded type "Number" methods
         * But we cannot manipulate the list because you cannot add integer to list of float
         * Compiler treats the list items as number
         */
        for(Number n: list) {
            System.out.println(n.intValue());
        }

        //compile time error
//        list.add(3);
    }
    public static void main(String[] args) {
        List<Float> list = Arrays.asList(1.1f,2.2f,3.3f,4.4f);
        show(list);

        //compile time error
        //Only Integer or subtype of Integer list allowed
//        List<Number> numList = new ArrayList<>();
//        intList(numList);

        List<Integer> intList = new ArrayList<>();
        intList(intList);
        show(intList);
    }
}
