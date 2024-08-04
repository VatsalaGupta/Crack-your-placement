import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * RedundantConnection
 */
public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};  // Correct syntax for initialization
        RedundantConnection rc = new RedundantConnection();
        int[] result = rc.findRedundantConnection(edges);
        if (result.length > 0) {
            System.out.println("Redundant Connection: [" + result[0] + "," + result[1] + "]");
        } else {
            System.out.println("No Redundant Connection Found.");
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges to the adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            
            // Check for cycle
            if (isCycle(V, adj)) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    // Function to detect cycle in an undirected graph using BFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V + 1];  // V + 1 to handle 1-based index nodes
        for (int i = 1; i <= V; i++) {  // Start from 1 to V
            if (!vis[i]) {
                if (bfs(adj, vis, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node, -1));
        vis[node] = true;
        
        while (!q.isEmpty()) {
            Pair t = q.poll();
            int n = t.node;
            int parent = t.parent;
            
            for (Integer it : adj.get(n)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(new Pair(it, n));
                } else if (it != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    class Pair {
        int node;
        int parent;
        
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
