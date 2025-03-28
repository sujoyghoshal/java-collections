import java.util.*;

class MyStack<T> {
    private Queue<T> mainQueue = new LinkedList<>();
    private Queue<T> tempQueue = new LinkedList<>();
    
    // Push element onto stack
    public void push(T x) {
        // Add new element to empty temp queue
        tempQueue.add(x);
        
        // Move all elements from main queue to temp queue
        while (!mainQueue.isEmpty()) {
            tempQueue.add(mainQueue.remove());
        }
        
        // Swap the queues
        Queue<T> q = mainQueue;
        mainQueue = tempQueue;
        tempQueue = q;
    }
    
    // Remove element from top of stack
    public T pop() {
        return mainQueue.remove();
    }
    
    // Get top element without removing
    public T top() {
        return mainQueue.peek();
    }
    
    // Check if stack is empty
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

public class StackWithQueues {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.top()); // 1
    }
}