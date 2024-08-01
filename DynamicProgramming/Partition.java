public class Partition {
    public static void main(String[] args) {
        int N = 4;
        int[] arr = {1, 5, 11, 5};
        int result = equalPartition(N, arr);
        System.out.println(result);
    }

    static int equalPartition(int N, int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // If the total sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) return 0;

        sum /= 2; // Target sum for each subset
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // Zero sum is always possible with an empty subset

        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[sum] ? 1 : 0;
    }
}
