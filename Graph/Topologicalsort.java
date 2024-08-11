import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topologicalsort {
    public static void main(String[] args) {
        // Example usage
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Add edges (example graph)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        int[] result = topoSort(V, adj);
        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        
        // Calculate indegree of each vertex
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        // Initialize the queue with vertices having 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] res = new int[V];
        int index = 0;
        
        // Process the queue
        while (!q.isEmpty()) {
            int curr = q.poll();
            res[index++] = curr;
            
            for (int it : adj.get(curr)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        // Check if topological sorting was possible
        if (index != V) {
            // Graph contains a cycle
            throw new IllegalStateException("Graph is not a DAG; topological sorting is not possible.");
        }
        
        return res;
    }
}
