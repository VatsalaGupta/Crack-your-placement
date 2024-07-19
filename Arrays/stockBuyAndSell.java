package Arrays;

public class stockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println("Maximum profit: " + profit);
    }

    public static int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxprofit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) { // Start loop from 1 as mini is already set to prices[0]
            int cost = prices[i] - mini;
            maxprofit = Math.max(maxprofit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxprofit;
    }
}
//