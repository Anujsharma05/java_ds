package generics;

import java.util.Arrays;

public class GenericArrayList<T> {

    private Object[] data;
    private int DEFAULT_SIZE = 10;
    private int size = 0;

    public GenericArrayList() {
        data = new Object[DEFAULT_SIZE];
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
        GenericArrayList<String> list = new GenericArrayList();

        list.add("ha");
        System.out.println(list);
    }
}
