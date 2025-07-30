//https://leetcode.com/problems/missing-number/submissions/1716845773/?envType=problem-list-v2&envId=binary-search
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};  // Example input
        int missing = missingNumber(nums);
        System.out.println("Missing Number is: " + missing);
    }
}
