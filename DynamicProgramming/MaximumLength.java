public class MaximumLength {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};

        MaximumLength maxLen = new MaximumLength();
        int result = maxLen.findLength(nums1, nums2);

        System.out.println("Maximum length of subarray: " + result);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int k = nums2.length;
        int[][] dp = new int[m + 1][k + 1];
        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
