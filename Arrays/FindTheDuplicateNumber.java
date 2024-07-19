package Arrays;
import java.util.*;
class findTheDuplicateNumber {
    public static void main(String args[]) {
        int nums[] = { 3, 4, 4, 4, 4 };
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) {
            if (hs.contains(x)) {
                return x;
            } else {
                hs.add(x);
            }
        }
        return -1;
    }
}