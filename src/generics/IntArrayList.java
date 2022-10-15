package generics;

import java.util.Arrays;

public class IntArrayList {

    private int[] data;
    private int DEFAULT_SIZE = 10;
    private int size = 0;

    public IntArrayList() {
        data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {

        if(isFull()) {
            resize();
        }

        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];

        for(int i=0; i<data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    public int remove() {
        return data[--size];
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        return data[index];
    }

    public void set(int index ,int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "IntArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        IntArrayList list = new IntArrayList();

        for(int i=0; i<13; i++) {
            list.add(i+2);
        }
        System.out.println(list);
    }
}
