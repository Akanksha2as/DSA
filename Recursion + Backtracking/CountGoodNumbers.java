//https://leetcode.com/problems/count-good-numbers/submissions/1674325899/
public class CountGoodNumbers {
    static final long MOD = 1_000_000_007;

    public static int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenWays = modPow(5, evenPos, MOD);
        long oddWays = modPow(4, oddPos, MOD);

        return (int)((evenWays * oddWays) % MOD);
    }

    public static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));    
        System.out.println(countGoodNumbers(4));    
        System.out.println(countGoodNumbers(50));  
    }
}
