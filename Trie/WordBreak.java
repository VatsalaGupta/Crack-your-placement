package Trie;

import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        ArrayList<String> B = new ArrayList<>();
        B.add("i");
        B.add("like");
        B.add("sam");
        B.add("sung");
        B.add("samsung");
        B.add("mobile");
        B.add("ice");
        B.add("cream");
        B.add("icecream");
        B.add("man");
        B.add("go");
        B.add("mango");
        
        String A = "ilike";

        int result = wordBreak(A, B);
        System.out.println("Can the string be segmented? " + (result == 1 ? "Yes" : "No"));
    }

    public static int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> wordSet = new HashSet<>(B);
        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true;  // Base case: empty string

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[A.length()] ? 1 : 0;
    }
}
