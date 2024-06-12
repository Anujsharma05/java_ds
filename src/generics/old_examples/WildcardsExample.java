package generics.old_examples;

import java.util.Arrays;
import java.util.List;

//wild card for Number and its subclasses
public class WildcardsExample<T extends Number> {

    private Object[] data;
    private int DEFAULT_SIZE = 10;
    private int size = 0;

    public WildcardsExample() {
        data = new Object[DEFAULT_SIZE];
    }

    public void getList(List<? extends Number> numbers) {
        //this is called wildcards. It makes sure that only Number class
        //and subclasses of Number can be passed here
    }

    public void add(T num) {

        if (isFull()) {
            resize();
        }

        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    public T remove() {
        T removed = (T) data[--size];
        return removed;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "GenericArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        WildcardsExample<Integer> list = new WildcardsExample();

        list.add(3);
        System.out.println(list);
    }
}
