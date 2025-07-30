//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/1716745786/
public class MinimumBitFlips {
    public static int minBitFlips(int start, int goal) {
        
        int xor = start ^ goal;
        int count = 0;

        while (xor != 0) {
            count += xor & 1; 
            xor >>= 1;      
        }

        return count;
    }

    public static void main(String[] args) {
        int start = 10;  
        int goal = 7;   
        int result = minBitFlips(start, goal);
        System.out.println("Minimum Bit Flips: " + result);
    }
}
