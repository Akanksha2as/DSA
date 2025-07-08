//https://leetcode.com/problems/4sum-ii/submissions/1690971251/
import java.util.HashMap;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                count += map.getOrDefault(sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSumII solution = new FourSumII();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int result = solution.fourSumCount(A, B, C, D);
        System.out.println("Number of tuples: " + result); 
    }
}
