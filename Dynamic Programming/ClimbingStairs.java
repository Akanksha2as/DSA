//https://leetcode.com/problems/climbing-stairs/submissions/1677773824/?envType=problem-list-v2&envId=dynamic-programming
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {
        int n = 5; 
        System.out.println("Number of distinct ways to climb to the top: " + climbStairs(n));
    }
}
