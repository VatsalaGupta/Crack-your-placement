import java.util.Arrays;

public class Segments {
    public static void main(String[] args) {
        int N = 4;
        int x = 2, y = 1, z = 1;
        
        Segments segments = new Segments();
        int result = segments.maximizeCuts(N, x, y, z);
        
        System.out.println("Maximum cuts possible: " + result);
    }

    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0; // Base case: 0 length segment has 0 cuts
        
        return solve(n, x, y, z, dp);
    }

    public int solve(int n, int x, int y, int z, int[] dp) {
        if (n < 0) {
            return Integer.MIN_VALUE; // Return a very small number if n is negative
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int a = solve(n - x, x, y, z, dp);
        int b = solve(n - y, x, y, z, dp);
        int c = solve(n - z, x, y, z, dp);

        // Choose the maximum cuts possible from the three options
        int ans = Math.max(a, Math.max(b, c));

        // If ans is still a very small number, no cuts were possible, else add 1 for the cut
        dp[n] = (ans == Integer.MIN_VALUE) ? ans : ans + 1;
        
        return dp[n];
    }
}
