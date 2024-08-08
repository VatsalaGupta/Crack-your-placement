import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphCycle {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Add edges
        adj[0].add(1);
        adj[1].add(0);
        adj[1].add(2);
        adj[1].add(4);
        adj[2].add(1);
        adj[2].add(3);
        adj[3].add(2);
        adj[3].add(4);
        adj[4].add(1);
        adj[4].add(3);

        UndirectedGraphCycle solution = new UndirectedGraphCycle();
        if (solution.isCycle(V, adj)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }

    public void dfs(List<Integer>[] adj, boolean[] vis, int node, int prev, boolean[] check) {
        vis[node] = true; // Mark the current node as visited
        for (int i : adj[node]) {
            if (i == prev) {
                continue; // Skip the edge leading back to the parent node
            }
            if (vis[i]) {
                check[0] = true; // Cycle detected
            } else {
                dfs(adj, vis, i, node, check);
            }
        }
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V]; // Initialize visited array
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean[] check = new boolean[1];
                dfs(adj, vis, i, -1, check);
                if (check[0]) {
                    return true; // Return true if a cycle is detected
                }
            }
        }
        return false; // No cycle detected
    }
}
