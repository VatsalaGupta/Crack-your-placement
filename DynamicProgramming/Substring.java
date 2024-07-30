import java.util.Arrays;

public class Substring {
    static int ans = 0;
    static int[][] dp = new int[1001][1001];

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        
        Substring substring = new Substring();
        int result = substring.longestCommonSubstr(s1, s2, s1.length(), s2.length());
        
        System.out.println("Length of the longest common substring: " + result);
    }

    int longestCommonSubstr(String s1, String s2, int n, int m) {
        ans = 0;
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        
        solve(s1, s2, n, m);
        return ans;
    }

    static int solve(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n - 1][m - 1] != -1) {
            return dp[n - 1][m - 1];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n - 1][m - 1] = 1 + solve(s1, s2, n - 1, m - 1);
            ans = Math.max(ans, dp[n - 1][m - 1]);
        } else {
            dp[n - 1][m - 1] = 0;
            solve(s1, s2, n, m - 1);
            solve(s1, s2, n - 1, m);
        }
        
        return dp[n - 1][m - 1];
    }
}
