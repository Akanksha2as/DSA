//https://leetcode.com/problems/continuous-subarrays/submissions/1698670522/?envType=problem-list-v2&envId=queue
import java.util.*;

public class ContinuousSubarrays {

    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        ContinuousSubarrays solution = new ContinuousSubarrays();
        int[] nums = {1, 3, 2, 4, 2};
        
        long result = solution.continuousSubarrays(nums);
        System.out.println("Number of continuous subarrays: " + result);
    }
}
