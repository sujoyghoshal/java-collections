import java.util.*;

public class QueueReverser {
    public static <T> void reverseQueue(Queue<T> queue) {
        // Use a stack to reverse the queue
        Stack<T> stack = new Stack<>();
        
        // Push all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        
        // Pop elements from stack back to queue (now reversed)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue); // [30, 20, 10]
    }
}