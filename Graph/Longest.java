public class Longest {
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(dfs(matrix, i, j, Integer.MIN_VALUE), res);
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int prevVal) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prevVal) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int curr = matrix[i][j];
        int temp = 0;
        temp = Math.max(temp, dfs(matrix, i + 1, j, curr));
        temp = Math.max(temp, dfs(matrix, i - 1, j, curr));
        temp = Math.max(temp, dfs(matrix, i, j + 1, curr));
        temp = Math.max(temp, dfs(matrix, i, j - 1, curr));

        dp[i][j] = temp + 1; // Add 1 to account for the current cell

        return dp[i][j];
    }
}
