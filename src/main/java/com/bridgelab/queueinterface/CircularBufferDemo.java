import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head = 0; // Points to oldest element
    private int tail = 0; // Points to next insertion point
    private int count = 0; // Number of elements
    
    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }
    
    // Add element to buffer, overwriting oldest if full
    public void add(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;
        
        if (count < size) {
            count++;
        } else {
            head = (head + 1) % size; // Move head if buffer is full
        }
    }
    
    // Remove and return oldest element
    public int remove() {
        if (count == 0) throw new NoSuchElementException("Buffer is empty");
        int value = buffer[head];
        head = (head + 1) % size;
        count--;
        return value;
    }
    
    // Get current buffer contents
    public List<Integer> getBufferContents() {
        List<Integer> contents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contents.add(buffer[(head + i) % size]);
        }
        return contents;
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println("Buffer: " + buffer.getBufferContents()); // [1, 2, 3]
        
        buffer.add(4); // Overwrites oldest element (1)
        System.out.println("Buffer: " + buffer.getBufferContents()); // [2, 3, 4]
        
        buffer.remove(); // Removes 2
        System.out.println("Buffer: " + buffer.getBufferContents()); // [3, 4]
    }
}