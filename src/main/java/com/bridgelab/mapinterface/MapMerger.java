import java.util.*;

public class MapMerger {
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        
        map2.forEach((key, value) -> 
            result.merge(key, value, Integer::sum)
        );
        
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        
        Map<String, Integer> merged = mergeMaps(map1, map2);
        System.out.println("Merged map: " + merged);
        // Output: {A=1, B=5, C=4}
    }
}