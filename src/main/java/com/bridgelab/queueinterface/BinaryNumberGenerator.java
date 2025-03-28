import java.util.*;

public class BinaryNumberGenerator {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        
        Queue<String> queue = new LinkedList<>();
        queue.add("1"); // Start with first binary number
        
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);
            
            // Generate next binary numbers by appending 0 and 1
            queue.add(current + "0");
            queue.add(current + "1");
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println("First 5 binary numbers: " + generateBinaryNumbers(5));
        // Output: [1, 10, 11, 100, 101]
    }
}