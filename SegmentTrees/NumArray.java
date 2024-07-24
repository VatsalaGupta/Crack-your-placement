public class NumArray {
    private int[] res;

    // Constructor to initialize the running sum array
    public NumArray(int[] nums) {
        this.res = new int[nums.length];
        this.res[0] = nums[0];

        // Compute running sum
        for (int i = 1; i < nums.length; i++) {
            this.res[i] = this.res[i - 1] + nums[i];
        }
    }

    // Method to calculate sum of elements in the given range
    public int sumRange(int left, int right) {
        return left > 0 ? this.res[right] - this.res[left - 1] : this.res[right];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);

        int param_1 = obj.sumRange(0, 2); // Should return 1
        int param_2 = obj.sumRange(2, 5); // Should return -1
        int param_3 = obj.sumRange(0, 5); // Should return -3

        System.out.println("sumRange(0, 2): " + param_1);
        System.out.println("sumRange(2, 5): " + param_2);
        System.out.println("sumRange(0, 5): " + param_3);
    }
}
