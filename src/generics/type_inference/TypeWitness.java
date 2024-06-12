package generics.type_inference;

import java.util.ArrayList;
import java.util.List;

/**
 * Type witness is when we explicitly mention the type of generic parameter
 * and not relying on compiler's inference
 */
public class TypeWitness {
    public static <T> List<T> add(List<T> list, T t1, T t2) {
        list.add(t1);
        list.add(t2);
        return list;
    }

    public static void main(String[] args) {
        TypeWitness.<Integer>add(new ArrayList<>(), 3, 5);
    }
}
