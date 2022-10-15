package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// We are not sure about how many threads we need in the pool
public class CachedThreadPoolExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> runJob("job 1"));
        executorService.execute(() -> runJob("job 2"));
        executorService.execute(() -> runJob("job 3"));

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
