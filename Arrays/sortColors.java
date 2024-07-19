package Arrays;

import java.util.Arrays;

public class sortColors {
    public static void main(String args[]){
        int nums[] = {2,0,2,1,1,0};
        sortColours(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColours(int[] nums) {
        int n = nums.length;
        int i = 0; // mid
        int j = 0; // low
        int k = n - 1; // high

        while (i <= k) {
            if (nums[i] == 0) {
                swap(nums, j, i);
                i++;
                j++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, k);
                k--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
