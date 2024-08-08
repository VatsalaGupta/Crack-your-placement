import java.util.ArrayList;

public class DirectedGraphCycle {
    public static void main(String[] args) {
        // Example usage
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (example graph with a cycle)
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Create instance of Solution
        Solution solution = new DirectedGraphCycle().new Solution();
        
        // Check for cycle
        boolean hasCycle = solution.isCyclic(V, adj);
        System.out.println("Graph contains a cycle: " + hasCycle);
    }

    class Solution {
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            int[] vis = new int[V];
            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    if (dfs(i, adj, vis)) return true;
                }
            }
            return false;
        }

        public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
            vis[node] = 1; // Mark the node as visiting
            for (Integer it : adj.get(node)) {
                if (vis[it] == 0) {
                    if (dfs(it, adj, vis)) return true;
                } else if (vis[it] == 1) {
                    return true; // Cycle detected
                }
            }
            vis[node] = 2; // Mark the node as visited
            return false;
        }
    }
}

