package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PredictableLatch {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

//      1 in argument indicates that wait for one event
        CountDownLatch latch = new CountDownLatch(1);

        executorService.execute(() -> waitForLatchThenPrint(latch));

        for(int i=0; i<100; i++) {
            System.out.println("main thread: " + Thread.currentThread().getName());
        }

        latch.countDown();

        //graceful termination
        executorService.shutdown();
        //abrupt termination
        executorService.shutdownNow();
    }

    static void waitForLatchThenPrint(CountDownLatch latch) {
        try {
            latch.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i<100; i++) {
            System.out.println("child thread: " + Thread.currentThread().getName());
        }
    }
}
