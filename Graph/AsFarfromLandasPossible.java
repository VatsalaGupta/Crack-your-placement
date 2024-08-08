import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        AsFarfromLandasPossible solution = new AsFarfromLandasPossible();
        System.out.println("Max distance: " + solution.maxDistance(grid));
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        // Add all land cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        // If the grid is all land or all water, return -1
        if (q.isEmpty() || q.size() == n * n) return -1;
        
        int res = -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            res++; // Increase distance as we go level by level
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                for (int[] dir : dirs) {
                    int i = x + dir[0], j = y + dir[1];
                    if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0) {
                        grid[i][j] = 1; // Mark cell as visited
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        
        return res;
    }
}
