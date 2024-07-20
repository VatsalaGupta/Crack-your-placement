package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        
        fourSum solution = new fourSum();
        List<List<Integer>> result = solution.four_Sum(nums, target);
        
        System.out.println("The quadruplets that sum to " + target + " are: " + result);
    }
    
    public List<List<Integer>> four_Sum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Sort the array
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            // Avoid duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Avoid duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        // Avoid duplicates for the third number
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        // Avoid duplicates for the fourth number
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
