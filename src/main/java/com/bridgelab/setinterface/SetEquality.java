import java.util.*;

public class SetEquality {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        // Sets are equal if they contain the same elements, regardless of order
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        
        System.out.println("Are sets equal? " + areSetsEqual(set1, set2)); // true
    }
}