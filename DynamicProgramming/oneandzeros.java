

public class oneandzeros {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        oneandzeros obj = new oneandzeros();
        int result = obj.findMaxForm(strs, m, n);
        System.out.println("The maximum size of the subset is: " + result);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; ++i) {
            int[] count = count(strs[i - 1]);
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {
                    if (j >= count[0] && k >= count[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int[] count(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }
}
