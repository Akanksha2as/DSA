//https://leetcode.com/problems/subarray-sum-equals-k/submissions/1689687799/
import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {1, 2, 3};
        int k = 3;

        int result = solution.subarraySum(nums, k);
        System.out.println("Total subarrays with sum " + k + ": " + result);
    }
}
