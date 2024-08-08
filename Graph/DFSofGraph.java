import java.util.ArrayList;

public class DFSofGraph {
    public static void main(String[] args) {
        int V = 5;
        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(2);

        DFSofGraph graph = new DFSofGraph();
        ArrayList<Integer> result = graph.dfsOfGraph(V, adj);

        System.out.println(result);  // Output the DFS traversal
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[V]; // Initialize visited array
        recursiveDFS(adj, arr, 0, visited);
        return arr;
    }

    public void recursiveDFS(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> arr, int node, boolean[] visited) {
        visited[node] = true; // Mark the current node as visited
        arr.add(node); // Add the node to the result list

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                recursiveDFS(adj, arr, neighbor, visited);
            }
        }
    }
}

