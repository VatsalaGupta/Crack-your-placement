package Arrays;

public class reversePairs {
    private int count = 0;

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};

        reversePairs rp = new reversePairs();
        int result = rp.reversepairs(nums);

        System.out.println(result);  // Output: expected result based on reverse pairs logic
    }

    public int reversepairs(int[] nums) {
        count = 0; // Reset count for each new call
        merge(nums, 0, nums.length - 1);
        return count;
    }

    public int[] merge(int[] nums, int si, int ei) {
        if (si == ei) {
            return new int[]{nums[si]};
        }

        int mid = si + (ei - si) / 2;
        int[] m1 = merge(nums, si, mid);
        int[] m2 = merge(nums, mid + 1, ei);

        // Count reverse pairs
        int p2 = 0;
        for (int p1 = 0; p1 < m1.length; p1++) {
            while (p2 < m2.length && (long) m1[p1] > 2 * (long) m2[p2]) {
                p2++;
            }
            count += p2;
        }

        // Merge two sorted arrays
        int[] merged = new int[ei - si + 1];
        int p = 0, p1 = 0;
        while (p1 < m1.length || p2 < m2.length) {
            if (p1 < m1.length && p2 < m2.length) {
                merged[p++] = m1[p1] <= m2[p2] ? m1[p1++] : m2[p2++];
            } else if (p1 < m1.length) {
                merged[p++] = m1[p1++];
            } else {
                merged[p++] = m2[p2++];
            }
        }
        return merged;
    }
}
