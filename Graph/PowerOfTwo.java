//https://leetcode.com/problems/power-of-two/submissions/1709547595/
public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16; 
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
