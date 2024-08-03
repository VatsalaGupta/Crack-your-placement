package Heap;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] result = solution.maxSlidingWindow(nums, k);
        
        System.out.println("Sliding window maximums: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove indices of elements not greater than the current element
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            
            // Add the current index to the deque
            q.addLast(i);
            
            // Remove the index of the element that is out of the current window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            
            // Add the maximum of the current window to the results
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
}
