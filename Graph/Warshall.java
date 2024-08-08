public class Warshall {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 3, -1, -1 },
                { -1, 0, 1, -1 },
                { -1, -1, 0, 2 },
                {-1, -1, -1, 0}
        };

        Warshall wf = new Warshall();
        wf.shortestDistance(matrix);

        // Print the result
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print((val == -1 ? "INF" : val) + " ");
            }
            System.out.println();
        }
    }

    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != -1 && matrix[k][j] != -1) {
                        if (matrix[i][j] == -1 || matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }
        }
    }
}
