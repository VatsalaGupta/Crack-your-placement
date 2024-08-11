import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders {
    public static void main(String[] args) {
        // Example usage
        SnakesandLadders solver = new SnakesandLadders();
        int[][] board = {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,36} // Example board
        };
        System.out.println(solver.snakesAndLadders(board)); // Output: 6 (or any result based on board configuration)
    }

    int length;
    int[][] board;

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        this.length = board.length;
        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(1, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = current + 1; i <= current + 6; i++) {
                int next = i;
                int mappedPosition = getPosition(i);
                if (mappedPosition != -1) {
                    next = mappedPosition;
                }
                if (next == length * length) {
                    return visited.get(current) + 1;
                }
                if (!visited.containsKey(next) && next <= length * length) {
                    visited.put(next, visited.get(current) + 1);
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    private int getPosition(int n) {
        int row = (n - 1) / length;
        int col = (n - 1) % length;
        if (row % 2 == 1) {
            col = length - 1 - col;
        }
        row = length - 1 - row;

        int result = board[row][col];
        return result == -1 ? n : result;
    }
}
