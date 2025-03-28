import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String item : list) {
            // If item exists in map, increment count, else add with count 1
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(fruits);
        System.out.println("Frequency Map: " + result);
    }
}