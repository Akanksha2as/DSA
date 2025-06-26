//https://leetcode.com/problems/fibonacci-number/submissions/1676621008/
public class Fibonacci {
    public static int fib(int n) {
        if (n <= 1) return n;

        int prev1 = 0, prev2 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        int n = 10;  
        int result = fib(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }
}
