import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1},
            {1, 0}
        };
        
        ShortestBridge sb = new ShortestBridge();
        int result = sb.shortestBridge(grid);
        System.out.println("Shortest bridge length: " + result);
    }

    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean foundIsland = false;

        // Find and mark one island using DFS
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    foundIsland = true;
                    break;
                }
            }
            if (foundIsland) break;
        }

        // Use BFS to find the shortest bridge to the second island
        return findNearestIslandBFS(grid, q);
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == 0)
            return;

        grid[i][j] = -1; // Mark as visited
        q.offer(new int[]{i, j}); // Add to queue for BFS

        // Explore all 4 directions
        dfs(grid, i - 1, j, q); // Up
        dfs(grid, i, j + 1, q); // Right
        dfs(grid, i + 1, j, q); // Down
        dfs(grid, i, j - 1, q); // Left
    }

    private int findNearestIslandBFS(int[][] grid, Queue<int[]> q) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int i = cell[0];
                int j = cell[1];

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    
                    if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || grid[ni][nj] == -1)
                        continue;

                    if (grid[ni][nj] == 1)
                        return level;

                    grid[ni][nj] = -1; // Mark as visited
                    q.offer(new int[]{ni, nj});
                }
            }
            level++;
        }

        return -1; // No path found (shouldn't happen for valid input)
    }
}
