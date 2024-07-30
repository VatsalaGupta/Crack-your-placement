import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteandEarn {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2}; // Proper initialization
        DeleteandEarn solution = new DeleteandEarn();
        int result = solution.deleteAndEarn(nums);
        System.out.println("Maximum points we can earn: " + result);
    }
    
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        
        List<int[]> list = new ArrayList<>();
        for (int num : nums) {
            if (!list.isEmpty() && list.get(list.size() - 1)[0] == num) {
                list.get(list.size() - 1)[1]++;
            } else {
                list.add(new int[]{num, 1});
            }
        }
        
        int n = list.size(); 
        int[] memo = new int[n];
        Arrays.fill(memo, -1); // Initialize memoization array to -1 (uncomputed)
        
        return dp(list, 0, memo, n);
    }
    
    private int dp(List<int[]> list, int idx, int[] memo, int n) {
        if (idx >= n)
            return 0;
        
        if (memo[idx] != -1)
            return memo[idx];
        
        int curr = list.get(idx)[0] * list.get(idx)[1]; 
        int nextToAdj = dp(list, idx + 2, memo, n) + curr;
        
        int adj = dp(list, idx + 1, memo, n);
        if (idx < n - 1 && list.get(idx + 1)[0] != list.get(idx)[0] + 1) {
            adj += curr;
        }
        
        memo[idx] = Math.max(adj, nextToAdj);
        return memo[idx];
    }
}
