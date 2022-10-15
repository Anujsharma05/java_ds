package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            try {
//                Thread.sleep(3000);
                TimeUnit.SECONDS.sleep(3);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0; i<1000; i++) {
                System.out.println("child thread: " + Thread.currentThread().getName());
            }
        });

        for(int i=0; i<1000; i++) {
            System.out.println("main thread: " + Thread.currentThread().getName());
        }

        //graceful termination
        executorService.shutdown();
        //abrupt termination
        executorService.shutdownNow();
    }
}
