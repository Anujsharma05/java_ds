package multithreading;

class MyThread extends Thread {

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            System.out.println("child thread 1: " + Thread.currentThread().getName());
        }
    }
}

class MyThreadTwo implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            System.out.println("runnable : " + Thread.currentThread().getName());
        }
    }
}

//Old way of multithreading, not recommended, better approach is ExecutorService
public class ExampleOne {
    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();

        Thread t2 = new Thread(new MyThreadTwo());
        t2.start();

        for(int i=0; i<1000; i++) {
            System.out.println("main thread: " + Thread.currentThread().getName());
        }
    }
}
