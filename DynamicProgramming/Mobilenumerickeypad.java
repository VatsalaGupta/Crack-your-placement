import java.util.Arrays;

public class Mobilenumerickeypad {
    public static void main(String[] args) {
        int n = 1;
        Mobilenumerickeypad keypad = new Mobilenumerickeypad();
        long result = keypad.getCount(n);
        System.out.println("Number of possible sequences of length " + n + ": " + result);
    }

    public long helper(int n, int i, int j, long[][][] dp) {
        if (i < 0 || i > 3 || j < 0 || j > 2 || (i == 3 && (j == 0 || j == 2))) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[i][j][n] != -1) {
            return dp[i][j][n];
        }
        n--;
        dp[i][j][n + 1] = helper(n, i - 1, j, dp) + // move up
                           helper(n, i + 1, j, dp) + // move down
                           helper(n, i, j - 1, dp) + // move left
                           helper(n, i, j + 1, dp);  // move right
        return dp[i][j][n + 1];
    }

    public long getCount(int n) {
        long ans = 0;
        long[][][] dp = new long[4][3][n + 1];
        for (long[][] temp : dp) {
            for (long[] row : temp) {
                Arrays.fill(row, -1);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 3 && (j == 0 || j == 2)) {
                    continue; // skip invalid positions
                }
                ans += helper(n, i, j, dp);
            }
        }
        return ans;
    }
}
