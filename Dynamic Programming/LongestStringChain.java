//https://leetcode.com/problems/longest-string-chain/submissions/1682559958/
import java.util.*;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); 
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (String word : words) {
            int best = 1;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            maxLen = Math.max(maxLen, best);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestStringChain solver = new LongestStringChain();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result = solver.longestStrChain(words);
        System.out.println("Longest String Chain Length: " + result);  
    }
}
