//https://leetcode.com/problems/powx-n/submissions/1674315944/
public class PowerFunction {
    public static double myPow(double x, int n) {
        long N = n; 
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
        System.out.println("2^10 = " + myPow(2.0, 10));     
        System.out.println("2^-2 = " + myPow(2.0, -2));     
        System.out.println("3^0 = " + myPow(3.0, 0));       
    }
}
