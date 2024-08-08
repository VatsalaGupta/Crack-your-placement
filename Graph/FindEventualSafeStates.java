import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        FindEventualSafeStates solution = new FindEventualSafeStates();
        List<Integer> result = solution.eventualSafeNodes(graph);
        System.out.println("Safe nodes: " + result);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] reverseGraph = new ArrayList[n];
        int[] indegree = new int[n];
        
        // Initialize reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        // Build reverse graph and calculate indegree
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph[neighbor].add(i);
                indegree[i]++;
            }
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // Nodes with no outgoing edges are safe (indegree == 0)
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int prevNode : reverseGraph[node]) {
                indegree[prevNode]--;
                if (indegree[prevNode] == 0) {
                    q.add(prevNode);
                }
            }
        }

        // Sort the result to ensure the nodes are in ascending order
        safeNodes.sort(Integer::compareTo);

        return safeNodes;
    }
}
