import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        FloodFill solution = new FloodFill();
        int[][] result = solution.floodFill(image, sr, sc, color);

        // Print the result
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        int startColor = image[sr][sc];
        
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color; // Mark the starting pixel as visited

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length && image[newX][newY] == startColor) {
                    image[newX][newY] = color;
                    q.offer(new int[]{newX, newY});
                }
            }
        }

        return image;
    }
}
