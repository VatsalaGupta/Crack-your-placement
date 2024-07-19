package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class chocolateDistributionProblem {
    public static void main(String[] args) {
        int N = 8;
        int M = 5;
        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : A) {
            list.add(num);
        }

        long result = findMinDiff(list, N, M);
        System.out.println("Minimum difference is: " + result);
    }

    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        if (m > a.size()) {
            return 0;
        }
        Collections.sort(a);
        long ans = Long.MAX_VALUE;

        int j = m - 1;
        int i = 0;

        while (j < a.size()) {
            long diff = a.get(j) - a.get(i);
            if (diff < ans) {
                ans = diff;
            }
            j++;
            i++;
        }

        return ans;
    }
}
