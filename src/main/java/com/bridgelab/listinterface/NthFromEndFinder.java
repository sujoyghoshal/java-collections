import java.util.*;

public class NthFromEndFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || list.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        // Use two pointers - fast and slow
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();
        
        // Move fast pointer n positions ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                throw new IllegalArgumentException("N is larger than list size");
            }
            fast.next();
        }
        
        // Move both pointers until fast reaches end
        T result = null;
        while (fast.hasNext()) {
            fast.next();
            result = slow.next();
        }
        
        return result != null ? result : slow.next(); // Handle case when n equals list size
    }

    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        String result = findNthFromEnd(letters, 2);
        System.out.println("2nd element from end: " + result); // Should print "D"
    }
}