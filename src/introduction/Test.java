package introduction;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    // Create a BlockingQueue with a capacity of 5
    BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

    // Adding elements
    queue.put("Element 1");  // Blocks if queue is full
    queue.offer("Element 2"); // Returns false if queue is full
    queue.put("hello");

    // Retrieving elements
//    String element = queue.take();  // Blocks if queue is empty
//    System.out.println("Taken: " + element);
//
//    element = queue.poll();  // Returns null if queue is empty
//    System.out.println("Polled: " + element);
//
//    // Examining the queue
//    element = queue.peek();  // Returns null if queue is empty
//    System.out.println("Peeked: " + element);
//
//    System.out.println("Queue size: " + queue.size());
//    System.out.println("Queue capacity: " + queue.remainingCapacity());
  }
}
