import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsinaNetwork {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(2, 0),
            Arrays.asList(1, 3)
        );

        CriticalConnectionsinaNetwork cc = new CriticalConnectionsinaNetwork();
        List<List<Integer>> result = cc.criticalConnections(n, connections);
        System.out.println("Critical Connections: " + result);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] adj = buildGraph(n, connections);
        int[] order = new int[n];
        Arrays.fill(order, -1);  // Initialize order array to -1 (unvisited)
        dfs(0, -1, 0, adj, order, res);

        return res;
    }

    // Return the node with the smallest order this branch can find
    private int dfs(int curr, int prev, int rank, List<Integer>[] adj, int[] order, List<List<Integer>> res) {
        if (order[curr] != -1) {
            return curr;
        }

        order[curr] = rank;
        int min = curr;
        for (int next : adj[curr]) {
            if (next == prev) {
                continue;
            }
            int smallest = dfs(next, curr, rank + 1, adj, order, res);
            if (order[smallest] == rank + 1) {
                res.add(Arrays.asList(curr, next));
            } else if (order[smallest] < order[min]) {
                min = smallest;
            }
        }

        return min;
    }

    // Build the adjacency list
    private List<Integer>[] buildGraph(int n, List<List<Integer>> connections) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }

        return adj;
    }
}
