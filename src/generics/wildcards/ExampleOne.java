package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class ExampleOne {
    public static void main(String[] args) {
        /**
         * Integer is subtype of Number, but List<Integer> is not subtype
         * of List<Number>
         */
        List<Integer> i = new ArrayList<>();
        //compile time error
//        List<Number> n = i;

        /**
         * To solve this problem, wildcard is used
         */
    }
}
