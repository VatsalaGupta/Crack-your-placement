package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        subsets obj = new subsets();
        List<List<Integer>> result = obj.subsetsWithDup(nums);
        System.out.println(result); // Expected output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> currentList = new ArrayList<>();
        generateSubsets(0, nums, currentList, set);

        return new ArrayList<>(set); // Convert set to list
    }

    private void generateSubsets(int index, int[] nums, List<Integer> currentList, Set<List<Integer>> set) {
        if (index >= nums.length) {
            set.add(new ArrayList<>(currentList));
            return;
        }

        // Include the current element
        currentList.add(nums[index]);
        generateSubsets(index + 1, nums, currentList, set);
        
        // Backtrack and exclude the current element
        currentList.remove(currentList.size() - 1);
        generateSubsets(index + 1, nums, currentList, set);
    }
}
