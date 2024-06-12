package reflection.section3.exercise;

import java.lang.reflect.Array;

public class ArrayReader {
    public static void main(String[] args) {
        int [] input = new int[] {0, 10, 20, 30, 40};
        String[] names = new String[] {"John", "Michael", "Joe", "David"};

        ArrayReader reader = new ArrayReader();

        Object value = reader.getArrayElement(input, 3);
        System.out.println(value.toString());

        Object ans = reader.getArrayElement(names, -1);
        System.out.println(ans.toString());
    }
    public Object getArrayElement(Object array, int index) {
        if(index < 0) {
            int length = Array.getLength(array);
            return Array.get(array, index + length);
        } else {
            return Array.get(array, index);
        }
    }
}
