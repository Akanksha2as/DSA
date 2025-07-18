//https://leetcode.com/problems/word-break/submissions/1674641654/
import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true; 

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; 
                }
            }
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        boolean result = solution.wordBreak(s, wordDict);
        System.out.println("Can the word be segmented? " + result);
    }
}
