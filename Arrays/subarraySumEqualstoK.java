package Arrays;

import java.util.HashMap;
import java.util.Map;

public class subarraySumEqualstoK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};  // Properly declare and initialize the array
        int k = 2;  // Properly declare and initialize k
        int result = subarraySum(nums, k);  // Call the subarraySum method
        System.out.println("Number of subarrays with sum equal to " + k + " is: " + result);
    }

    public static int subarraySum(int[] nums, int k) {  // Declare the method as static
        Map<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int count = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                count += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
