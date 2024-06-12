package stacks_queues.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * important operations:
 * throws exception: add, remove, element
 * without exception: offer, poll, peek
 */
public class QueueInbuilt {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        //Add, Offer
        queue.add("Anuj");
        queue.offer("Anuj");

        //Remove, Poll
        queue.remove();
        queue.poll();

        //Element, Peek
        queue.element();
        queue.peek();

    }
}
