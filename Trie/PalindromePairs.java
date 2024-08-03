package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        PalindromePairs solution = new PalindromePairs();
        List<List<Integer>> result = solution.palindromePairs(words);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> answer = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        int n = words.length;

        // Store all words and their indices in a map
        for (int i = 0; i < n; i++) {
            wordMap.put(words[i], i);
        }

        // Check all pairs of words
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int len = word.length();

            // Check for each possible split point in the word
            for (int j = 0; j <= len; j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                // Check if the left part is a palindrome
                if (isPalindrome(left)) {
                    String reverseRight = new StringBuilder(right).reverse().toString();
                    if (wordMap.containsKey(reverseRight) && wordMap.get(reverseRight) != i) {
                        answer.add(List.of(wordMap.get(reverseRight), i));
                    }
                }

                // Check if the right part is a palindrome
                if (j != len && isPalindrome(right)) {
                    String reverseLeft = new StringBuilder(left).reverse().toString();
                    if (wordMap.containsKey(reverseLeft) && wordMap.get(reverseLeft) != i) {
                        answer.add(List.of(i, wordMap.get(reverseLeft)));
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
