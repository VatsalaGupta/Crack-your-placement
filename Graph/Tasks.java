import java.util.*;

public class Tasks {
    public static void main(String[] args) {
        int N = 4;
        int P = 3;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        Tasks tasks = new Tasks();
        System.out.println(tasks.isPossible(N, P, prerequisites));
    }

    private boolean dfsCycle(Map<Integer, List<Integer>> adj, Set<Integer> visited, Set<Integer> dfsVisited, int node) {
        visited.add(node);
        dfsVisited.add(node);

        for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                boolean isCycle = dfsCycle(adj, visited, dfsVisited, neighbor);
                if (isCycle) {
                    return true;
                }
            } else if (dfsVisited.contains(neighbor)) {
                return true;
            }
        }
        dfsVisited.remove(node);
        return false;
    }

    public boolean isPossible(int N, int P, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> dfsVisited = new HashSet<>();

        for (int i = 0; i < N; i++) {
            if (!visited.contains(i)) {
                boolean isCycle = dfsCycle(adj, visited, dfsVisited, i);
                if (isCycle) {
                    return false;
                }
            }
        }
        return true;
    }
}
