import java.util.*;

public class MaxValueFinder {
    public static <K> K findKeyWithMaxValue(Map<K, Integer> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("A", 10);
        scores.put("B", 20);
        scores.put("C", 15);
        
        String maxKey = findKeyWithMaxValue(scores);
        System.out.println("Key with max value: " + maxKey); // Output: B
    }
}