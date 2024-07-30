public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        };

        MinimumPathSum pathSum = new MinimumPathSum();
        int result = pathSum.minPathSum(grid);

        System.out.println("Minimum path sum: " + result);
    }

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 && col == 0) {
                    // Start point, do nothing
                    grid[row][col] = grid[row][col];
                } else if (row == 0) {
                    // First row, can only come from the left
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                } else if (col == 0) {
                    // First column, can only come from above
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                } else {
                    // Rest of the grid, take the minimum of coming from the left or from above
                    grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }
        return grid[height - 1][width - 1];
    }
}
