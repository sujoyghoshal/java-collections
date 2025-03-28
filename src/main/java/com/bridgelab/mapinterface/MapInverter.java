import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);
        
        Map<Integer, List<String>> inverted = invertMap(original);
        System.out.println("Inverted map: " + inverted);
        // Output: {1=[A, C], 2=[B]}
    }
}