//https://leetcode.com/problems/remove-duplicate-letters/submissions/1698636724/?envType=problem-list-v2&envId=stack
import java.util.*;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (seen[c - 'a']) continue;

            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                char removed = stack.pop();
                seen[removed - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        String result = removeDuplicateLetters(s);
        System.out.println("Result: " + result);
    }
}
