//https://leetcode.com/problems/permutations/submissions/1674614634/
import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; 
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(nums, tempList, result, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1); 
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = obj.permute(nums);
        System.out.println("Permutations: " + result);
    }
}
