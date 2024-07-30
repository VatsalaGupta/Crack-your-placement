import java.util.ArrayList;

public class palindromic {
    public static void main(String[] args) {
        String S = "geeks";  // Corrected assignment of S
        ArrayList<ArrayList<String>> result = allPalindromicPerms(S);

        // Print the result
        for (ArrayList<String> partition : result) {
            System.out.println(partition);
        }
    }

    public boolean checkPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> currentPartition = new ArrayList<>();
        palindromic solution = new palindromic();  // Create an instance of Palindromic
        partition(result, S, 0, currentPartition, solution);
        return result;
    }

    private static void partition(
        ArrayList<ArrayList<String>> result, String s, int ind, ArrayList<String> currentPartition, palindromic solution
    ) {
        if (ind == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        String temp = "";

        for (int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);

            if (solution.checkPalindrome(temp)) {
                currentPartition.add(temp);
                partition(result, s, i + 1, currentPartition, solution);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
}