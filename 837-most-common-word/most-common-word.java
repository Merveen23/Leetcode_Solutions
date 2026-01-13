import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        // Convert banned words to a Set for fast lookup
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }

        // Normalize paragraph: lowercase + replace punctuation with space
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " ");

        // Split words
        String[] words = paragraph.split("\\s+");

        // Count frequency
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word.length() > 0 && !bannedSet.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // Find most frequent word
        String answer = "";
        int maxCount = 0;

        for (String key : freq.keySet()) {
            if (freq.get(key) > maxCount) {
                maxCount = freq.get(key);
                answer = key;
            }
        }

        return answer;
    }
}
