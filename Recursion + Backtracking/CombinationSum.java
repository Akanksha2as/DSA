//https://leetcode.com/problems/combination-sum/submissions/1674647311/
import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); 
            return;
        }
        if (target < 0 || index == candidates.length) {
            return; 
        }
        current.add(candidates[index]);
        backtrack(candidates, index, target - candidates[index], current, result);
        current.remove(current.size() - 1);

        backtrack(candidates, index + 1, target, current, result);
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> combinations = solution.combinationSum(candidates, target);
        System.out.println("Combinations summing to " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
