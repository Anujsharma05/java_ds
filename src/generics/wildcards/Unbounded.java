package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Unbounded {
    static void method1(List<?> list) {
        //compile time error because we cannot manipulate unbounded types
//        list.add("");

        //but we can see the content

        for(Object o: list) {
            System.out.println(o);
        }

        System.out.println(list.size());
        System.out.println(list.get(0));
        System.out.println(list.contains("anuj"));
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("anuj");
        method1(list);
    }
}
