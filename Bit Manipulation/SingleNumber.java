//https://leetcode.com/problems/single-number/submissions/1716797625/
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;  
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};  
        int unique = singleNumber(nums);
        System.out.println("Single Number is: " + unique);
    }
}
