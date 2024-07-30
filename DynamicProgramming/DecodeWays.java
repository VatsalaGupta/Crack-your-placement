import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "12";
        
        DecodeWays decoder = new DecodeWays();
        int result = decoder.numDecodings(s);
        
        System.out.println("Number of ways to decode: " + result);
    }

    public boolean isValid(int code, int len) {
        if (len == 1) {
            return code >= 1 && code <= 9;
        } else {
            return code >= 10 && code <= 26;
        }
    }

    public int countOfDecoding(int i, String s, int[] dp) {
        if (i >= s.length()) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = 0;
        if (isValid(s.charAt(i) - '0', 1)) {
            dp[i] += countOfDecoding(i + 1, s, dp);
        }
        if (i < s.length() - 1 && isValid((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0'), 2)) {
            dp[i] += countOfDecoding(i + 2, s, dp);
        }
        return dp[i];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return countOfDecoding(0, s, dp);
    }
}
