import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        FrogJump frogJump = new FrogJump();
        boolean result = frogJump.canCross(stones);
        System.out.println(result);
    }
    
    private boolean memoizationUtil(int[] stones, int position, int jump, Map<Integer, Integer> map, Boolean[][] dp) {
        if (position == stones.length - 1) {
            return true;
        }
        if (dp[position][jump] != null) {
            return dp[position][jump];
        }
        boolean local = false;
        if (map.containsKey(stones[position] + jump - 1) && jump - 1 > 0)
            local = local || memoizationUtil(stones, map.get(stones[position] + jump - 1), jump - 1, map, dp);
        if (map.containsKey(stones[position] + jump) && jump > 0)
            local = local || memoizationUtil(stones, map.get(stones[position] + jump), jump, map, dp);
        if (map.containsKey(stones[position] + jump + 1))
            local = local || memoizationUtil(stones, map.get(stones[position] + jump + 1), jump + 1, map, dp);
        dp[position][jump] = local;
        return local;
    }

    private boolean memoization(int[] stones) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        Boolean[][] dp = new Boolean[n][n];
        return memoizationUtil(stones, 0, 0, map, dp);
    }

    public boolean canCross(int[] stones) {
        return memoization(stones);
    }
}
