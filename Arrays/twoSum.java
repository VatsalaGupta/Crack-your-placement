package Arrays;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSm(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }
    }

    public static int[] twoSm(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (hm.containsKey(moreNeeded)) {
                return new int[]{hm.get(moreNeeded), i}; // Corrected order of indices
            }
            hm.put(num, i);
        }
        return new int[]{};
    }
}
