package generics.type_inference;

import static_keyword.A;

import java.util.ArrayList;
import java.util.List;

public class ExampleOne {
    static <T> List<T> add(List<T> list, T t1, T t2) {
        list.add(t1);
        list.add(t2);
        return list;
    }
    public static void main(String[] args) {
        /**
         * Compiler will infer type of "new ArrayList() to be String based on the arguments
         */
         add(new ArrayList<>(), "a", "b");

         add(new ArrayList<>(), 3, 5);
    }
}
