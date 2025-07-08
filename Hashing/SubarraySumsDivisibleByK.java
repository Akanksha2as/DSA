//https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/1690962931/
import java.util.HashMap;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); 
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            count += remainderCount.getOrDefault(rem, 0);
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK obj = new SubarraySumsDivisibleByK();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = obj.subarraysDivByK(nums, k);
        System.out.println("Number of subarrays divisible by " + k + ": " + result);
    }
}
