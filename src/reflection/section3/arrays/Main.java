package reflection.section3.arrays;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int[] oneDimensionalArray = {1,2};
        double[][] twoDimensionalArray = {{2.2, 4.3}, {1.1, 4.2}};

        inspectArrayObject(twoDimensionalArray);
//        inspectArrayValues(twoDimensionalArray);
    }

    /**
     * Using java.lang.reflect.Array helper class
     */
    static void inspectArrayValues(Object arrayObject) {
        Class<?> arrayClass = arrayObject.getClass();

        int length = Array.getLength(arrayObject);

        System.out.print("[");
        for(int i=0; i<length; i++) {

            Object element = Array.get(arrayObject, i);

            if(element.getClass().isArray()) {
                inspectArrayValues(element);
            } else {
                System.out.print(element);
            }

            if(i != length-1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    static void inspectArrayObject(Object arrayObject) {

        Class<?> arrayClass = arrayObject.getClass();

        System.out.println("Is Array: " + arrayClass.isArray());

        Class<?> arrayComponentType = arrayClass.getComponentType();

        System.out.println(String.format("This is an array of type: %s", arrayComponentType.getTypeName()));
    }
}
