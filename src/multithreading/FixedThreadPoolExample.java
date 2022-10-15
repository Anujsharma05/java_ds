package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// We know how many threads we want in the pool
public class FixedThreadPoolExample {
    public static void main(String[] args) {

        //for two jobs
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> runJob("job 1"));
        executorService.execute(() -> runJob("job 2"));

        runJob("main thread");

        //graceful termination
        executorService.shutdown();
        //abrupt termination
        executorService.shutdownNow();
    }

    static void runJob(String message) {
        for(int i=0; i<15; i++) {
            System.out.println(message + ": " + Thread.currentThread().getName());
        }
    }
}
