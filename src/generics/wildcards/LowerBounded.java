package generics.wildcards;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class LowerBounded {

    /**
     * String and Number both implements Serializable interface
     */
    public static void showAll(List<? super Number> list) {
        for(Object obj: list) {
            System.out.println(obj);
        }
    }

    public static void testMethod(List<? super Number> ints) {
        Object a = 4;
        Integer i = 2;
        Number n = 1;
        ints.add(i);
        ints.add(n);
    }
    public static void main(String[] args) {
        List<? super Integer> l1 = new ArrayList<>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();

        //show items
        List<Serializable> ser = new ArrayList<>();
        ser.add("one");
        ser.add("two");
        ser.add("three");
        showAll(ser);

        List<? super Number> nums = new ArrayList<Object>();
        List<Object> a = null;
        nums.add(1.1f);
        nums.add(1.2d);
        nums.add(1);
        nums.add(3l);
//        nums.add(a);

        /**
         * Compile time error
         */
//        List<Integer> n = new ArrayList<>();
//        testMethod(n);

        List<Object> lObj = new ArrayList<>();
        testMethod(lObj);

        for(Object obj: nums) {
            System.out.println(obj);
        }
    }
}
