import java.util.HashSet;
import java.util.Set;

public class Count {
    public static void main(String[] args) {
        String s = "bccb";
        Count solution = new Count();
        int result = solution.countPalindromicSubsequences(s);
        System.out.println(result);
    }

    private static final int MOD = 1_000_000_007;
    private Set<String> set = new HashSet<>();
    @SuppressWarnings("unused")
    private int count = 0;

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @SuppressWarnings("unused")
    private void solveRec(String s, int idx, StringBuilder sb) {
        if (idx >= s.length()) {
            if (sb.length() != 0 && isPalindrome(sb.toString()) && !set.contains(sb.toString())) {
                count++;
                set.add(sb.toString());
                return;
            }
            return;
        }

        sb.append(s.charAt(idx));
        solveRec(s, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        solveRec(s, idx + 1, sb);
    }

    private int solveMemo(String s, int start, int end, Integer[][] dp) {
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int res = 0;
        if (s.charAt(start) == s.charAt(end)) {
            int left = start + 1;
            int right = end - 1;
            while (left <= right && s.charAt(left) != s.charAt(start)) left++;
            while (left <= right && s.charAt(right) != s.charAt(end)) right--;

            if (left < right) {
                res += 2 * solveMemo(s, start + 1, end - 1, dp) - solveMemo(s, left + 1, right - 1, dp);
            } else if (left > right) {
                res += 2 * solveMemo(s, start + 1, end - 1, dp) + 2;
            } else {
                res += 2 * solveMemo(s, start + 1, end - 1, dp) + 1;
            }
        } else {
            res += solveMemo(s, start + 1, end, dp) + solveMemo(s, start, end - 1, dp) - solveMemo(s, start + 1, end - 1, dp);
        }

        return dp[start][end] = res < 0 ? res + MOD : res % MOD;
    }

    public int countPalindromicSubsequences(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return solveMemo(s, 0, s.length() - 1, dp);
    }
}
