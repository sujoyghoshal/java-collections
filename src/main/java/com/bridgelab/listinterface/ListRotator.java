import java.util.*;

public class ListRotator {
    public static <T> void rotateList(List<T> list, int positions) {
        if (list.isEmpty()) return;
        
        // Handle cases where positions is larger than list size
        positions = positions % list.size();
        if (positions < 0) {
            positions += list.size(); // Handle negative rotations
        }
        
        // Rotate by reversing three parts of the list
        // 1. Reverse the entire list
        Collections.reverse(list);
        // 2. Reverse first 'positions' elements
        Collections.reverse(list.subList(0, positions));
        // 3. Reverse remaining elements
        Collections.reverse(list.subList(positions, list.size()));
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List: " + numbers);
        rotateList(numbers, 2);
        System.out.println("After rotating by 2: " + numbers);
    }
}