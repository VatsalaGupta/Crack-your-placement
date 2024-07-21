package Arrays;

import java.util.*;

public class AllUniquePermutationsOfAnArray {
    
    private void solve(List<Integer> arr, int n, int s, List<List<Integer>> ans, Set<List<Integer>> a) {
        if (s == n) {
            if (a.contains(arr)) {
                return;
            }
            a.add(new ArrayList<>(arr));
            ans.add(new ArrayList<>(arr));
            return;
        }
        for (int i = s; i < n; i++) {
            Collections.swap(arr, s, i);
            solve(arr, n, s + 1, ans, a);
            Collections.swap(arr, s, i); // Backtrack to restore the original array
        }
    }

    public List<List<Integer>> uniquePerms(List<Integer> arr, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> a = new HashSet<>();
        int s = 0;
        solve(arr, n, s, ans, a);
        Collections.sort(ans, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size() && i < o2.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i))) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return o1.size() - o2.size();
            }
        });
        return ans;
    }

    public static void main(String[] args) {
        AllUniquePermutationsOfAnArray sol = new AllUniquePermutationsOfAnArray();
        List<Integer> arr = Arrays.asList(1, 2, 3);
        int n = arr.size();
        List<List<Integer>> result = sol.uniquePerms(arr, n);
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
