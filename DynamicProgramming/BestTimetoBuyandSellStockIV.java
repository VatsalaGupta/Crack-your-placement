import java.util.Arrays;

public class BestTimetoBuyandSellStockIV {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        BestTimetoBuyandSellStockIV solution = new BestTimetoBuyandSellStockIV();
        int result = solution.maxProfit(k, prices);
        System.out.println(result);
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return solve(0, n, 0, k, prices, dp);
    }

    int solve(int index, int n, int buy, int k, int[] prices, int[][][] dp) {
        if (index == n || k == 0) {
            return 0;
        }
        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(0 + solve(index + 1, n, 0, k, prices, dp), -prices[index] + solve(index + 1, n, 1, k, prices, dp));
        } else {
            profit = Math.max(0 + solve(index + 1, n, 1, k, prices, dp), prices[index] + solve(index + 1, n, 0, k - 1, prices, dp));
        }
        return dp[index][buy][k] = profit;
    }
}
