package Heap;

import java.util.LinkedList;
import java.util.Queue;

public class SwiminRisingWater {
    public static void main(String[] args) {
        int[][] grid = {{0, 2}, {1, 3}};
        
        SwiminRisingWater solution = new SwiminRisingWater();
        int result = solution.swimInWater(grid);
        
        System.out.println("Minimum time to swim to the bottom-right: " + result);
    }
    
    private int[][] grid;
    private int n;
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    private boolean canSwim(int x) {
        if (grid[0][0] > x) return false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            if (r == n - 1 && c == n - 1) return true;
            
            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && grid[nr][nc] <= x) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
    
    public int swimInWater(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        int left = 0;
        int right = 0;
        for (int[] row : grid) {
            for (int value : row) {
                right = Math.max(right, value);
            }
        }
        
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSwim(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
