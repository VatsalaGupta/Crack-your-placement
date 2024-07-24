public class CountofRangeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        
        CountofRangeSum obj = new CountofRangeSum();
        int result = obj.countRangeSum(nums, lower, upper);
        System.out.println(result); // Expected output: 3
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
