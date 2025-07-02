//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1684189630/
import java.util.*;

public class LongestUniqueSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestUniqueSubstring solution = new LongestUniqueSubstring();

        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);

        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}
