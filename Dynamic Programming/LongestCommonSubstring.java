//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
public class LongestCommonSubstring {

    public static String longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        int maxLength = 0;
        int endIndex = 0; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return s1.substring(endIndex - maxLength, endIndex);
    }

    public static void main(String[] args) {
        String s1 = "ABABC";
        String s2 = "BABCAC";

        String result = longestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring: " + result);
    }
}
