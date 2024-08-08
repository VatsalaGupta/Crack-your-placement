import java.util.ArrayList;

public class RatInMazeProblem {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        RatInMazeProblem solution = new RatInMazeProblem();
        ArrayList<String> result = solution.findPath(mat);

        // Print the result
        for (String path : result) {
            System.out.println(path);
        }
    }
    
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    String[] dirStr = {"U", "D", "L", "R"};
    
    void findPaths(int[][] mat, int n, int i, int j, StringBuilder str, ArrayList<String> res) {
        // Base conditions
        if (i >= n || j >= n || i < 0 || j < 0 || mat[i][j] == 0) {
            return;
        }
        
        // If destination is reached
        if (i == n - 1 && j == n - 1) {
            res.add(str.toString());
            return;
        }
        
        // Mark the cell as visited
        mat[i][j] = 0;
        
        // Explore all 4 possible directions
        for (int k = 0; k < 4; k++) {
            int newX = i + dir[k][0];
            int newY = j + dir[k][1];
            
            str.append(dirStr[k]);
            findPaths(mat, n, newX, newY, str, res);
            str.deleteCharAt(str.length() - 1);
        }
        
        // Unmark the cell to allow other paths
        mat[i][j] = 1;
    }
    
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        if (mat.length == 0 || mat[0].length == 0 || mat[0][0] == 0) {
            return res; // Return empty if start is blocked
        }
        
        findPaths(mat, mat.length, 0, 0, str, res);
        
        return res;
    }
}
