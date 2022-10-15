package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Balance {

    /**
     * Approach one
     */
//    int balance = 0;
//
//    public synchronized void increment() {
//        balance++; // it is not a single step it is multiple steps to increment
//    }

    AtomicInteger balance = new AtomicInteger(0);

    public void increment() {
        balance.incrementAndGet();
    }
}

public class LostUpdateExample {
    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(6);

        Balance balance = new Balance();

        for(int i=0; i<10000; i++) {
            service.execute(() -> balance.increment());
        }

        service.shutdown();

        if(service.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("balance = " + balance.balance);
        }
    }
}
