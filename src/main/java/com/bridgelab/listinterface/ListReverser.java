import java.util.*;

public class ListReverser {
    public static <T> void reverseList(List<T> list) {
        // Use two pointers approach
        int start = 0;
        int end = list.size() - 1;
        
        while (start < end) {
            // Swap elements at start and end
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            
            // Move pointers towards center
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Test with ArrayList
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
        
        // Test with LinkedList
        List<String> linkedList = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}