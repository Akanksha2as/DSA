//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/submissions/1716851970/
public class MaxParenthesisDepth {

    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (ch == ')') {
                depth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum Depth: " + maxDepth(s));  // Output: 3
    }
}
