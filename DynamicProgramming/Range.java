public class Range {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);

        // Perform the sumRegion queries
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}

class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        sums = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] + matrix[i - 1][j - 1] - sums[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int RED_RECTANGLE = sums[row2 + 1][col2 + 1];
        int PURPLE_RECTANGLES = sums[row1][col2 + 1] + sums[row2 + 1][col1];
        int BLUE_RECTANGLE = sums[row1][col1];
        return RED_RECTANGLE - PURPLE_RECTANGLES + BLUE_RECTANGLE;
    }
}
