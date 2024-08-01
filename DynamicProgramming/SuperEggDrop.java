import java.util.Arrays;

public class SuperEggDrop {
    public static void main(String[] args) {
        int k = 1; // Number of eggs
        int n = 2; // Number of floors
        SuperEggDrop solution = new SuperEggDrop();
        int result = solution.superEggDrop(k, n);
        System.out.println(result);
    }

    private int[][] t;

    public int superEggDrop(int k, int n) {
        t = new int[k + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(k, n);
    }

    private int solve(int e, int f) {
        if (f == 0) return 0;
        if (f == 1 || e == 1) return f;

        if (t[e][f] != -1) return t[e][f];

        int ans = Integer.MAX_VALUE;
        int l = 1, h = f;

        // Use binary search instead of linear search
        while (l <= h) {
            int mid = (l + h) / 2;
            int left = solve(e - 1, mid - 1);
            int right = solve(e, f - mid);
            int temp = 1 + Math.max(left, right);

            if (left < right) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }

            ans = Math.min(ans, temp);
        }

        return t[e][f] = ans;
    }
}
