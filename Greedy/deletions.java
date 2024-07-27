package Greedy;

import java.util.HashMap;
import java.util.HashSet;

public class deletions {

    public static void main(String[] args) {
        String s = "aab";
        deletions deletions = new deletions();
        int result = deletions.minDeletions(s);
        System.out.println("Minimum deletions: " + result);
    }

    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        // Ensure unique frequencies
        for (Character key : map.keySet()) {
            int val = map.get(key);
            while (val > 0 && set.contains(val)) {
                count++;
                val--;
            }
            set.add(val);
        }
        return count;
    }
}
