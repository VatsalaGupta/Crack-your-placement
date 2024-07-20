package Arrays;

public class BestTimetoBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // Corrected array initialization

        BestTimetoBuyAndSellStockII solution = new BestTimetoBuyAndSellStockII();
        int profit = solution.maxProfit(prices); // Calling the maxProfit method

        System.out.println("Max profit: " + profit); // Printing the result
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit = profit + (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
