//https://leetcode.com/problems/partition-equal-subset-sum/submissions/1678842258/
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
    public static void main(String[] args) {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();

        int[] nums = {1, 5, 11, 5};
        System.out.println("Can partition? " + obj.canPartition(nums)); 
    }
}
