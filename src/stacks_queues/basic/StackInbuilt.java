package stacks_queues.basic;

import java.util.Stack;

/**
 * important operations: push, pop, peek
 */
public class StackInbuilt {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Anuj");
        stack.push("Zoro");
        stack.push("Sanji");
        stack.push("Robin");
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.contains("Zoro"));
        System.out.println(stack.get(2));
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
