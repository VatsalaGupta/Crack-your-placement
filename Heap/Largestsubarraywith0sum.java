package Heap;

import java.util.HashMap;

public class Largestsubarraywith0sum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = arr.length;

        Largestsubarraywith0sum solution = new Largestsubarraywith0sum();
        int result = solution.maxLen(arr, n);

        System.out.println("Length of the largest subarray with sum 0 is: " + result);
    }

    public int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
