

public class subarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4}; // Correctly initializing the array
        subarray obj = new subarray();
        int result = obj.maxProduct(nums);
        System.out.println("Maximum product of a subarray: " + result);
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                // Swap max and min products if the current number is negative
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}

