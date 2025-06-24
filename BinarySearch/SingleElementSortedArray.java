//https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/1674306490/
public class SingleElementSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2; 
            } else {
                high = mid; 
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5, 5}; 
        System.out.println("Single Element: " + singleNonDuplicate(nums));
    }
}
