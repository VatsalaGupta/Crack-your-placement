
import java.util.Arrays;

public class countingbits {
    public static void main(String[] args) {
        int n = 2; // Correctly initializing the variable n
        countingbits obj = new countingbits();
        int[] result = obj.countBits(n);
        System.out.println("Number of bits: " + Arrays.toString(result));
    }

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }

            dp[i] = dp[i - sub] + 1;
        }

        return dp;        
    }
}
