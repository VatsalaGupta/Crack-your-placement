public class SubMatrices {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        SubMatrices subMatrices = new SubMatrices();
        int result = subMatrices.countSquares(matrix);
        
        System.out.println("Total number of square submatrices: " + result);
    }

    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;

        // Initialize the first row
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
            ans += dp[0][i];
        }

        // Initialize the first column
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        // Fill the dp array
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans += dp[i][j];
            }
        }

        return ans;
    }
}
