package Arrays;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args){
      int nums[] = {1,1,2};
      System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=nums[i]){
              nums[i+1]=nums[j];
              i++;
            }
        }
        return i+1;
    }

}
