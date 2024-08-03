package Heap;

import java.util.Stack;

public class FindtheMostCompetitiveSubsequence {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6};
        int k = 2;

        FindtheMostCompetitiveSubsequence solution = new FindtheMostCompetitiveSubsequence();
        int[] result = solution.mostCompetitive(nums, k);

        System.out.print("Most competitive subsequence: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && nums.length - i > k - stack.size()) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
