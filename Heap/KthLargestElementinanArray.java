package Heap;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElementinanArray solution = new KthLargestElementinanArray();
        int result = solution.findKthLargest(nums, k);
        
        System.out.println("The " + k + "-th largest element is " + result);
    }

    public int findKthLargest(int[] nums, int k) {
        // Min-Heap to keep track of the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }
}
