//https://leetcode.com/problems/powx-n/submissions/1716848964/
public class PowerCalculator {

    public static double myPow(double x, int n) {
        long N = n; // To handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -3;
        System.out.println("Result: " + myPow(x, n));  // Output: 0.125
    }
}
