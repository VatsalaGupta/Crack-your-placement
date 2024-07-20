package Arrays;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};  
        int result = majorityEle(nums);  
        System.out.println("The majority element is: " + result);
    }
    
    public static int majorityEle(int[] nums) {  
        int count = 0;
        int ele = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                ele = nums[i];
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;
            }
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) {
                cnt++;
            }
        }
        if (cnt > (nums.length / 2)) {
            return ele;
        }
        return -1;
    }
}
