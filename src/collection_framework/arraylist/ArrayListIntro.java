package collection_framework.arraylist;

import java.util.ArrayList;

public class ArrayListIntro {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list);

        ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();
        System.out.println(listOfList);
    }
}
