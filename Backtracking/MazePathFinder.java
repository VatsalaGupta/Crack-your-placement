import java.util.ArrayList;

public class MazePathFinder {

    // Rows and columns in given maze
    private static final int N = 9;
    // For searching in all 4 directions
    private static final int[] row = { -1, 1, 0, 0 };
    private static final int[] col = { 0, 0, -1, 1 };
    // Coordinates of 4 corners of matrix
    private static final int[] _row = { 0, 0, N - 1, N - 1 };
    private static final int[] _col = { 0, N - 1, 0, N - 1 };

    // Check whether given cell is a valid cell or not.
    private static boolean isValid(ArrayList<int[]> visited, int[] pt) {
        // Check if cell is not visited yet to avoid cycles (infinite loop) and its
        // row and column number is in range
        return (pt[0] >= 0) && (pt[0] < N) && (pt[1] >= 0) && (pt[1] < N)
                && (!visited.stream().anyMatch(item -> item[0] == pt[0] && item[1] == pt[1]));
    }

    // Function to print path from source to middle coordinate
    private static void printPath(ArrayList<int[]> path) {
        StringBuilder pathStr = new StringBuilder();
        for (int[] i : path) {
            pathStr.append("(").append(i[0]).append(", ").append(i[1]).append(") -> ");
        }
        pathStr.append("MID");
        System.out.println(pathStr);
    }

    private static void findPathInMazeUtil(int[][] maze, ArrayList<int[]> path, ArrayList<int[]> visited, int[] curr) {
        // If we have reached the destination cell, print the complete path
        if (curr[0] == (N / 2) && curr[1] == (N / 2)) {
            printPath(path);
            return;
        }
        // Consider each direction
        for (int i = 0; i < 4; i++) {
            // Get value of current cell
            int n = maze[curr[0]][curr[1]];
            // We can move N cells in either of 4 directions
            int x = curr[0] + row[i] * n;
            int y = curr[1] + col[i] * n;
            int[] next = { x, y };
            // If valid pair
            if (isValid(visited, next)) {
                // Mark cell as visited
                visited.add(next);
                // Add cell to current path
                path.add(next);
                // Recurse for next cell
                findPathInMazeUtil(maze, path, visited, next);
                // Backtrack: remove cell from current path
                path.remove(path.size() - 1);
                visited.removeIf(item -> item[0] == next[0] && item[1] == next[1]);
            }
        }
    }

    // Function to find a path from corner cell to middle cell in maze containing
    // positive numbers
    public static void findPathInMaze(int[][] maze) {
        // List to store complete path from source to destination
        ArrayList<int[]> path = new ArrayList<>();
        // To store cells already visited in current path
        ArrayList<int[]> visited = new ArrayList<>();
        // Consider each corner as the starting point and search in maze
        for (int i = 0; i < 4; i++) {
            int x = _row[i];
            int y = _col[i];
            int[] pt = { x, y };
            // Mark cell as visited
            visited.add(pt);
            // Add cell to current path
            path.add(pt);
            findPathInMazeUtil(maze, path, visited, pt);
            // Backtrack: remove cell from current path
            path.remove(path.size() - 1);
            visited.removeIf(item -> item[0] == pt[0] && item[1] == pt[1]);
        }
    }

    public static void main(String[] args) {
        // Input maze
        int[][] maze = {
                { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
                { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
                { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
                { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
                { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
                { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
                { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
                { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
                { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
        };

        // Find path from corner cell to middle cell in the maze
        findPathInMaze(maze);
    }
}
