

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationsum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        combinationsum2 obj = new combinationsum2();
        List<List<Integer>> result = obj.combinationSum2(candidates, target);
        System.out.println(result); // Expected output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort the array to handle duplicates and make it easier to manage combinations
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> comb, List<List<Integer>> res) {
        if (target < 0) {
            return; // If target is negative, there's no point in continuing
        }

        if (target == 0) {
            res.add(new ArrayList<Integer>(comb)); // If we hit the target, add the current combination to the results
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }

            if (candidates[i] > target) {
                break; // If the current candidate is greater than the target, break the loop
            }

            comb.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, comb, res); // Move to the next candidate
            comb.remove(comb.size() - 1); // Backtrack and remove the last added candidate
        }
    }
}
