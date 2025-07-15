//https://leetcode.com/problems/sum-of-subarray-minimums/submissions/1698665382/?envType=problem-list-v2&envId=stack
import java.util.*;

public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            result = (result + arr[i] * left * right) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums solution = new SumOfSubarrayMinimums();
        int[] arr = {3, 1, 2, 4};

        System.out.println("Sum of Subarray Minimums: " + solution.sumSubarrayMins(arr));
    }
}
