package Backtracking;

public class BeautifulArrangement {
    int res = 0;

    public static void main(String[] args) {
        int n = 2; // Initialize n
        BeautifulArrangement obj = new BeautifulArrangement();
        int result = obj.countArrangement(n);
        System.out.println(result); // Expected output: 2
    }

    public int countArrangement(int n) {
        if (n == 0) return 0;
        backtrack(1, n, new int[n + 1]);
        return res;
    }

    private void backtrack(int pos, int n, int[] usedValueArr) {
        if (pos > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (usedValueArr[i] == 0 && (pos % i == 0 || i % pos == 0)) {
                usedValueArr[i] = 1;
                backtrack(pos + 1, n, usedValueArr);
                usedValueArr[i] = 0;
            }
        }
    }
}
