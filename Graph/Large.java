import java.util.HashSet;
import java.util.Set;

public class Large {
    private int[] parent;
    private int[] size;

    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parent = new int[rows * cols];
        size = new int[rows * cols];
        int maxIslandSize = 0;

        // Initialize union-find structures
        for (int i = 0; i < rows * cols; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Union adjacent land cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int currentIndex = i * cols + j;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        int topIndex = (i - 1) * cols + j;
                        union(currentIndex, topIndex);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        int leftIndex = i * cols + (j - 1);
                        union(currentIndex, leftIndex);
                    }
                }
            }
        }

        // Compute the largest island size by flipping each zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> roots = new HashSet<>();
                    int potentialIslandSize = 1; // Initial size for the new island

                    if (i > 0 && grid[i - 1][j] == 1) {
                        roots.add(findParent((i - 1) * cols + j));
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        roots.add(findParent(i * cols + (j - 1)));
                    }
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        roots.add(findParent((i + 1) * cols + j));
                    }
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        roots.add(findParent(i * cols + (j + 1)));
                    }

                    for (int root : roots) {
                        potentialIslandSize += size[root];
                    }

                    maxIslandSize = Math.max(maxIslandSize, potentialIslandSize);
                }
            }
        }

        // Consider the case when the grid is initially all 1s
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxIslandSize = Math.max(maxIslandSize, size[findParent(i * cols + j)]);
                }
            }
        }

        return maxIslandSize;
    }

    private int findParent(int x) {
        if (x != parent[x]) {
            parent[x] = findParent(parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu != pv) {
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Large solver = new Large();
        int[][] grid = {
            {1, 0},
            {0, 1}
        };
        System.out.println(solver.largestIsland(grid)); // Example output
    }
}
