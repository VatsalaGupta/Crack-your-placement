import java.util.ArrayDeque;
import java.util.Queue;

public class StepsbyKnight {
    public static void main(String[] args) {
        int N = 6;
        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};

        StepsbyKnight solver = new StepsbyKnight();
        int result = solver.minStepToReachTarget(knightPos, targetPos, N);
        System.out.println("Minimum steps to reach target: " + result);
    }

    public int minStepToReachTarget(int[] pos, int[] to, int N) {
        // Possible moves of a knight
        int[][] moves = { {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {-1, 2}, {1, 2}, {-2, -1}, {-2, 1} };
        
        // Initialize board to store number of steps
        int[][] board = new int[N + 1][N + 1];
        for (int[] row : board) {
            java.util.Arrays.fill(row, 0);
        }

        // Queue for BFS
        Queue<Integer> queue = new ArrayDeque<>();
        
        // Encode the starting position
        int start = (pos[0] << 16) | pos[1];
        queue.add(start);
        board[pos[0]][pos[1]] = 1;

        while (!queue.isEmpty()) {
            int encodedPos = queue.poll();
            int i0 = encodedPos >> 16; // Extract row
            int j0 = encodedPos & 0xFFFF; // Extract column

            // Check if we have reached the target
            if (i0 == to[0] && j0 == to[1]) {
                return board[i0][j0] - 1;
            }

            // Explore all possible moves
            for (int[] move : moves) {
                int i = i0 + move[0];
                int j = j0 + move[1];
                
                if (i >= 1 && i <= N && j >= 1 && j <= N && board[i][j] == 0) {
                    board[i][j] = board[i0][j0] + 1;
                    int encodedMove = (i << 16) | j;
                    queue.add(encodedMove);
                }
            }
        }
        
        return -1; // Target not reachable
    }
}
