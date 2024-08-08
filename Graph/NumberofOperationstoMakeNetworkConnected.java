import java.util.HashSet;

public class NumberofOperationstoMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        
        NumberofOperationstoMakeNetworkConnected obj = new NumberofOperationstoMakeNetworkConnected();
        int result = obj.makeConnected(n, connections);
        System.out.println("Number of operations required: " + result);
    }
    
    private void dfs(int start, HashSet<Integer>[] graph, boolean[] visited) {
        visited[start] = true;
        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
    
    private void fullGraph(HashSet<Integer>[] graph, int[][] connections) {
        for (int[] con : connections) {
            graph[con[0]].add(con[1]);
            graph[con[1]].add(con[0]);
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; // Not enough connections to connect all nodes
        }
        
        HashSet<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        
        fullGraph(graph, connections);
        
        boolean[] visited = new boolean[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }
        
        return components - 1; // Number of edges needed to connect all components
    }
}
