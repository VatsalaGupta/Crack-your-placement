import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class City {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        City city = new City();
        System.out.println("The city with the smallest number of reachable neighbors: " + city.findTheCity(n, edges, distanceThreshold));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Convert graph to adjacency list representation
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1], distance = edge[2];
            graph.get(node1).add(new int[]{node2, distance});
            graph.get(node2).add(new int[]{node1, distance});
        }

        int minimumNumber = n;
        int result = -1;

        for (int source = 0; source < n; source++) {
            int neighbors = getNumberOfNeighborsInDistance(graph, source, n, distanceThreshold);
            // Iterate source from smaller to bigger ensures that we choose the node with the higher value in case of a tie
            if (neighbors <= minimumNumber) {
                minimumNumber = neighbors;
                result = source;
            }
        }

        return result;
    }

    private int getNumberOfNeighborsInDistance(List<List<int[]>> graph, int source, int n, int distanceThreshold) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, source}); // Distance to node itself is 0
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int distanceToThisNode = top[0], curNode = top[1];
            if (!visited.contains(curNode)) {
                visited.add(curNode);
                for (int[] neighbor : graph.get(curNode)) {
                    int distanceFromSource = distanceToThisNode + neighbor[1];
                    if (distanceFromSource <= distanceThreshold) { // Ensure we're allowed to go to this node
                        minHeap.add(new int[]{distanceFromSource, neighbor[0]});
                    }
                }
            }
        }

        // Return the number of reachable neighbors (excluding the source itself)
        return visited.size() - 1;
    }
}
