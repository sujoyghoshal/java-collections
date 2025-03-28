import java.util.*;
import java.util.regex.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequencies(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        // Remove punctuation and convert to lowercase
        String cleanedText = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        
        // Split into words and count frequencies
        String[] words = cleanedText.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequencyMap;
    }

    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        Map<String, Integer> frequencies = countWordFrequencies(text);
        System.out.println("Word frequencies: " + frequencies);
        // Output: {hello=2, world=1, java=1}
    }
}