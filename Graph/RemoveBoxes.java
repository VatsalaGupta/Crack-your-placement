import java.util.Arrays;

public class RemoveBoxes {
    private int solve(int l, int r, int count, int[] boxes, int[][][] dp) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][count] != -1) {
            return dp[l][r][count];
        }

        int i = l;
        int cnt = count;
        
        // Count the number of contiguous boxes with the same color
        while (i + 1 <= r && boxes[i + 1] == boxes[l]) {
            i++;
            cnt++;
        }

        // Case 1: Remove all contiguous boxes of the same color together
        int basic = (cnt + 1) * (cnt + 1) + solve(i + 1, r, 0, boxes, dp);

        // Case 2: Try to merge boxes of the same color that are not contiguous
        int merge = 0;
        for (int m = i + 1; m <= r; m++) {
            if (boxes[m] == boxes[l]) {
                merge = Math.max(merge, solve(m, r, cnt + 1, boxes, dp) + solve(i + 1, m - 1, 0, boxes, dp));
            }
        }

        return dp[l][r][count] = Math.max(basic, merge);
    }

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return solve(0, n - 1, 0, boxes, dp);
    }

    public static void main(String[] args) {
        RemoveBoxes rb = new RemoveBoxes();
        int[] boxes = {1, 3, 2, 2, 2, 1, 1};
        System.out.println(rb.removeBoxes(boxes)); // Example output
    }
}
