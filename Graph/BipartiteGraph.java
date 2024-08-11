import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to store colors of vertices
        int[] color = new int[V];
        Arrays.fill(color, -1); // -1 indicates that the vertex has not been colored yet

        // Check for bipartiteness for each component of the graph
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { // Not visited yet
                if (!bfsCheck(i, adj, color)) {
                    return false;
                }
            }
        }

        return true; // All components are bipartite
    }

    private boolean bfsCheck(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0; // Start coloring the starting vertex with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = color[node];
            
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) { // If the neighbor is not colored
                    color[neighbor] = 1 - currentColor; // Assign opposite color
                    queue.offer(neighbor);
                } else if (color[neighbor] == currentColor) { // If neighbor has the same color
                    return false; // Graph is not bipartite
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        BipartiteGraph checker = new BipartiteGraph();
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Example edges for a bipartite graph
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(checker.isBipartite(V, adj)); // Output: true
    }
}
