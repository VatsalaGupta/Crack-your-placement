import java.util.*;

public class MinimumSpanningTree {

    static class Node {
        int u, v, weight;
        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static int find(int a, int[] parent) {
        if (parent[a] != a) {
            parent[a] = find(parent[a], parent);
        }
        return parent[a];
    }

    public static boolean union(int a, int b, int[] parent, int[] rank) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);
        if (rootA == rootB) return false;
        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }

    public static int spanningTree(int v, int e, List<Node> edges) {
        Collections.sort(edges, (a, b) -> Integer.compare(a.weight, b.weight));

        int[] parent = new int[v];
        int[] rank = new int[v];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int sum = 0;
        int edgeCount = 0;

        for (Node edge : edges) {
            if (union(edge.u, edge.v, parent, rank)) {
                sum += edge.weight;
                edgeCount++;
                if (edgeCount == v - 1) break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Example usage
        int v = 3;
        int e = 3;

        List<Node> edges = new ArrayList<>();
        edges.add(new Node(0, 1, 5));
        edges.add(new Node(1, 2, 3));
        edges.add(new Node(0, 2, 1));

        System.out.println("Minimum Spanning Tree weight: " + spanningTree(v, e, edges));
    }
}
