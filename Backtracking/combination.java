package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class combination {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        combination obj = new combination();
        List<List<Integer>> result = obj.combine(n, k);
        System.out.println(result); // Expected output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
