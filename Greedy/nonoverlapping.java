package Greedy;

import java.util.Arrays;

public class nonoverlapping {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        nonoverlapping solution = new nonoverlapping();
        int result = solution.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return intervals.length - count;
    }
}
