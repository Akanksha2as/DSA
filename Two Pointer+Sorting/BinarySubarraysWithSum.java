//https://leetcode.com/problems/binary-subarrays-with-sum/submissions/1685846147/
import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            if (prefixSumFreq.containsKey(sum - goal)) {
                count += prefixSumFreq.get(sum - goal);
            }
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum solution = new BinarySubarraysWithSum();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println("Number of subarrays with sum " + goal + ": " + solution.numSubarraysWithSum(nums, goal));
    }
}
