package collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollection {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        /**
         * To make the list synchronized and the answer consistent
         */
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Runnable r1 = () -> {
            for(int i=0; i<1000; i++) {
                list.add(i);
            }
        };
        Thread t1 = new Thread(r1);

        Runnable r2 = () -> {
            for(int i=0; i<1000; i++) {
                list.add(i);
            }
        };
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        /**
         * Wait for threads to complete operation
         */
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        //Answer will be inconsistent because the list is not synchronized
        System.out.println(list.size());
    }
}
