package Arrays;

import java.util.*;

public class maxValueofEquation {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int k = 1;

        maxValueofEquation solution = new maxValueofEquation();
        int result = solution.findMaxValueOfEquation(points, k);

        System.out.println(result);  // Output: 4
    }

    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int maxValue = Integer.MIN_VALUE;
        Deque<int[]> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove points from the deque that are out of range
            while (!deque.isEmpty() && points[i][0] - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }

            // Calculate the current value
            if (!deque.isEmpty()) {
                maxValue = Math.max(maxValue, points[i][1] + deque.peekFirst()[1] + points[i][0] - deque.peekFirst()[0]);
            }

            // Maintain the deque with the highest `y - x` values
            while (!deque.isEmpty() && points[i][1] - points[i][0] > deque.peekLast()[1] - deque.peekLast()[0]) {
                deque.pollLast();
            }

            // Add the current point to the deque
            deque.offerLast(new int[]{points[i][0], points[i][1]});
        }

        return maxValue;
    }
}
