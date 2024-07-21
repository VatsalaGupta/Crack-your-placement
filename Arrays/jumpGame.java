package Arrays;

public class jumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        jumpGame game = new jumpGame();
        boolean result = game.canJump(nums);

        System.out.println(result);  // Output: true
    }

    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;        
    }
}
