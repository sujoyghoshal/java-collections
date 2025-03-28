import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCounts = new HashMap<>();
    private Map<String, Integer> insertionOrderVotes = new LinkedHashMap<>();

    // Add a vote for a candidate
    public void voteFor(String candidate) {
        voteCounts.put(candidate, voteCounts.getOrDefault(candidate, 0) + 1);
        insertionOrderVotes.put(candidate, insertionOrderVotes.getOrDefault(candidate, 0) + 1);
    }

    // Get results in insertion order
    public Map<String, Integer> getResultsInInsertionOrder() {
        return new LinkedHashMap<>(insertionOrderVotes);
    }

    // Get results sorted by candidate name
    public Map<String, Integer> getResultsSortedByName() {
        return new TreeMap<>(voteCounts);
    }

    // Get results sorted by vote count (descending)
    public Map<String, Integer> getResultsSortedByVotes() {
        Map<String, Integer> sorted = new TreeMap<>((a, b) -> {
            int compare = voteCounts.get(b).compareTo(voteCounts.get(a));
            return compare != 0 ? compare : a.compareTo(b);
        });
        sorted.putAll(voteCounts);
        return sorted;
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        
        system.voteFor("Alice");
        system.voteFor("Bob");
        system.voteFor("Alice");
        system.voteFor("Charlie");
        system.voteFor("Bob");
        
        System.out.println("Insertion order: " + system.getResultsInInsertionOrder());
        System.out.println("Sorted by name: " + system.getResultsSortedByName());
        System.out.println("Sorted by votes: " + system.getResultsSortedByVotes());
    }
}