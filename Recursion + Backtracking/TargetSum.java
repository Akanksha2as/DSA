//https://leetcode.com/problems/target-sum/submissions/1675468746/
import java.util.*;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return countWays(nums, 0, 0, target, memo);
    }

    private int countWays(int[] nums, int index, int currentSum, int target, Map<String, Integer> memo) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = index + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = countWays(nums, index + 1, currentSum + nums[index], target, memo);
        int subtract = countWays(nums, index + 1, currentSum - nums[index], target, memo);

        memo.put(key, add + subtract);
        return memo.get(key);
    }
    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1}; 
        int target = 3;
        System.out.println("Number of ways to reach target: " + ts.findTargetSumWays(nums, target));
    }
}
