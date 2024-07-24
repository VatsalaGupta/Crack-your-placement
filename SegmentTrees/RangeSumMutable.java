public class RangeSumMutable {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray obj = new NumArray(nums);

        int param_1 = obj.sumRange(0, 2); // Should return 9
        System.out.println("sumRange(0, 2): " + param_1);

        obj.update(1, 2); // nums becomes {1, 2, 5}

        int param_2 = obj.sumRange(0, 2); // Should return 8
        System.out.println("sumRange(0, 2): " + param_2);
    }

    //Approach -1

    // This will give you TLE for large arrays

    static class NumArray {
        private int[] nums;
        private int[] prefixSums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefixSums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSums[i + 1] = prefixSums[i] + nums[i];
            }
        }

        public void update(int index, int val) {
            int oldVal = nums[index];
            nums[index] = val;
            int diff = val - oldVal;
            for (int i = index + 1; i < prefixSums.length; i++) {
                prefixSums[i] += diff;
            }
        }

        public int sumRange(int left, int right) {
            return prefixSums[right + 1] - prefixSums[left];
        }
    }
}
