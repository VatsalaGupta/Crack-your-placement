import java.util.Arrays;

public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        BurstBalloons solution = new BurstBalloons();
        int result = solution.maxCoins(nums);
        System.out.println(result);
    }

    private int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(nums, 0, n - 1);
    }

    private int solve(int[] nums, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;
        for (int k = i; k <= j; k++) {
            int leftPart = solve(nums, i, k - 1);
            int rightPart = solve(nums, k + 1, j);
            int burst = nums[k] * (i - 1 < 0 ? 1 : nums[i - 1]) * (j + 1 >= nums.length ? 1 : nums[j + 1]);
            int temp = leftPart + rightPart + burst;
            max = Math.max(max, temp);
        }

        dp[i][j] = max;
        return dp[i][j];
    }
}
