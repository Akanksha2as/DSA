//https://leetcode.com/problems/decode-ways/submissions/1684182571/
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; 
        dp[1] = 1; 

        for (int i = 2; i <= n; i++) {
           
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];

            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();

        String input = "226";
        int result = solution.numDecodings(input);

        System.out.println("Number of ways to decode \"" + input + "\": " + result);
    }
}
