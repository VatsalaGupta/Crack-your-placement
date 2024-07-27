package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class restore {

    public static void main(String[] args) {
        int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
        restore restore = new restore();
        int[] restoredArray = restore.restoreArray(adjacentPairs);
        for (int num : restoredArray) {
            System.out.print(num + " ");
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        // Create a graph (adjacency list) to represent the pairs
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Populate the graph with the given adjacent pairs
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        List<Integer> result = new ArrayList<>();

        // Find a starting point: one of the endpoints (degree 1)
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                result.add(entry.getKey());
                result.add(entry.getValue().get(0));
                break;
            }
        }

        // Build the result array by traversing the graph
        while (result.size() < adjacentPairs.length + 1) {
            int last = result.get(result.size() - 1);
            int prev = result.get(result.size() - 2);
            List<Integer> candidates = graph.get(last);
            int nextElement = candidates.get(0) != prev ? candidates.get(0) : candidates.get(1);
            result.add(nextElement);
        }

        // Convert the result list to an array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
