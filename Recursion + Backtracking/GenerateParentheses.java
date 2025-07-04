//https://leetcode.com/problems/generate-parentheses/submissions/1675471212/
import java.util.*;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        int n = 3; 
        List<String> result = gp.generateParenthesis(n);

        System.out.println("Generated Parentheses for n = " + n + ":");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
