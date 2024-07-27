package Greedy;

import java.util.Arrays;

public class GFG {

    // Function to calculate minimum cost
    static int minCost(int coin[], int n, int k) {

        // Sort the coin values
        Arrays.sort(coin);

        // Calculate the number of coins needed
        int coinsNeeded = (int) Math.ceil(1.0 * n / (k + 1));

        // Calculate the sum of all selected coins
        int ans = 0;
        for (int i = 0; i < coinsNeeded; i++) {
            ans += coin[i];
        }

        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int coin[] = {8, 5, 3, 10, 2, 1, 15, 25};
        int n = coin.length;
        int k = 3;

        System.out.println("Minimum cost: " + minCost(coin, n, k));
    }
}
