import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofgraph {
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unused")
        int E = 4;

        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(4);

        BFSofgraph graph = new BFSofgraph();
        ArrayList<Integer> result = graph.bfsOfGraph(V, adj);

        System.out.println(result);  // Output the BFS traversal
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V]; // Initialize visited array
        Queue<Integer> que = new LinkedList<>();

        // Start BFS from node 0
        que.add(0);
        visited[0] = true;

        while (!que.isEmpty()) {
            int node = que.poll(); // Remove the node from the front of the queue
            bfs.add(node); // Add it to the BFS result

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    que.add(neighbor);
                    visited[neighbor] = true; // Mark as visited
                }
            }
        }

        return bfs;
    }
}
