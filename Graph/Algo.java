import java.util.*;

public class Algo {
    public static void main(String[] args) {
        // Example usage
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example edges
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);

        Algo solution = new Algo();
        int count = solution.kosaraju(V, adj);
        System.out.println("Number of Strongly Connected Components: " + count);
    }

    // First DFS to fill the stack
    void dfs(int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj) {
        vis[node] = true;
        for (int e : adj.get(node)) {
            if (!vis[e]) {
                dfs(e, vis, st, adj);
            }
        }
        st.push(node);
    }

    // Second DFS on the transposed graph
    void revofdfs(int node, boolean[] vis, Map<Integer, List<Integer>> transpose) {
        vis[node] = true;
        for (int e : transpose.get(node)) {
            if (!vis[e]) {
                revofdfs(e, vis, transpose);
            }
        }
    }

    // Kosaraju's algorithm to find all SCCs
    int kosaraju(int V, List<List<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        // Fill the stack with nodes in the order of their finishing times
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, st, adj);
            }
        }

        // Transpose the graph
        Map<Integer, List<Integer>> transpose = new HashMap<>();
        for (int i = 0; i < V; i++) {
            transpose.put(i, new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int e : adj.get(i)) {
                transpose.get(e).add(i);
            }
        }

        // Second DFS to count SCCs
        Arrays.fill(vis, false);
        int count = 0;
        while (!st.isEmpty()) {
            int top = st.pop();
            if (!vis[top]) {
                revofdfs(top, vis, transpose);
                count++;
            }
        }
        return count;
    }
}
