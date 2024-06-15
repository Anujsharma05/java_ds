package reflection.section4.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayFlattening {
    public static void main(String[] args) {
        ArrayFlattening flattening = new ArrayFlattening();
//        int [] result = flattening.concat(int.class, 1, 2, 3, new int[] {4, 5, 6}, new int[] {7,8,9});
        String [] result = flattening.concat(String.class, new String[]{"a", "b"}, "c", new String[] {"d", "e"});
        System.out.println(Arrays.toString(result));
    }
    public <T> T concat(Class<?> type, Object... arguments) {

        if (arguments.length == 0) {
            return null;
        }
        /**
         * Instead of calculating length, We can use List<Object> to store all the arguments values
         */
        int length = calculateLength(arguments);

        T arrayObject = (T) Array.newInstance(type, length);

        fillArray(arrayObject, arguments, 0);
        return arrayObject;
    }

    private <T> int fillArray(T arrayObject, Object arguments, int index) {
        int argLength = Array.getLength(arguments);
        for(int i=0; i<argLength; i++) {
            Object obj = Array.get(arguments, i);
            if(obj.getClass().isArray()) {
                index = fillArray(arrayObject, obj, index);
            } else {
                Array.set(arrayObject, index, obj);
                index++;
            }
        }
        return index;
    }

    private int calculateLength(Object arguments) {
        int argLength = Array.getLength(arguments);
        int length = 0;
        for(int i=0; i<argLength; i++) {
            Object obj = Array.get(arguments, i);
            if(obj.getClass().isArray()) {
               length = length + calculateLength(obj);
            } else {
                length += 1;
            }
        }
        return length;
    }
}
