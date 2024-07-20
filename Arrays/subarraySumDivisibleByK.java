package Arrays;

import java.util.HashMap;
import java.util.Map;

public class subarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 }; // Corrected array initialization
        int k = 5; // Define k

        subarraySumDivisibleByK solution = new subarraySumDivisibleByK(); // Creating an instance of the class
        int result = solution.subarraysDivByK(nums, k); // Calling the subarraysDivByK method

        System.out.println("Number of subarrays divisible by " + k + ": " + result); // Printing the result
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize the map with the base case
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            int remainder = (sum % k + k) % k;
            count += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
