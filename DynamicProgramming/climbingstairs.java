

public class climbingstairs {
    public static void main(String[] args) {
        int n = 2; // Correctly initializing the variable n
        climbingstairs obj = new climbingstairs();
        int result = obj.climbStairs(n);
        System.out.println("Number of ways to climb " + n + " stairs: " + result);
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
