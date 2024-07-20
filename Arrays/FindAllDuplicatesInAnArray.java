package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // Corrected array initialization

        FindAllDuplicatesInAnArray solution = new FindAllDuplicatesInAnArray();
        List<Integer> duplicates = solution.findDuplicates(nums); // Calling the findDuplicates method

        System.out.println("Duplicates: " + duplicates); // Printing the result
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
        }
        return ans;
    }
}
