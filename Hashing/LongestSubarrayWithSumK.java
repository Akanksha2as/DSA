//https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
import java.util.HashMap;

public class LongestSubarrayWithSumK {

    public int longestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumK solution = new LongestSubarrayWithSumK();

        int[] nums = {1, 2, 3, 1, 1, 1, 1};
        int k = 4;

        int result = solution.longestSubarray(nums, k);
        System.out.println("Length of longest subarray with sum " + k + ": " + result);
    }
}
