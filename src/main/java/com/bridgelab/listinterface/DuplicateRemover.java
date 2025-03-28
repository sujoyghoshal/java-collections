import java.util.*;

public class DuplicateRemover {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>(); // Maintains insertion order
        List<T> result = new ArrayList<>();
        
        for (T item : list) {
            if (seen.add(item)) { // add returns true if item wasn't in set
                result.add(item);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List with duplicates removed: " + uniqueNumbers);
    }
}