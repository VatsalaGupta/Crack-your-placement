package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean[][] graph = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new Solve().graphColoring(graph, M, N) ? 1 : 0);
        }

        scan.close();
    }
}

class Solve {
    private boolean isPossible(int node, ArrayList<ArrayList<Integer>> edges, int[] colors, int color) {
        for (int neighbor : edges.get(node)) {
            if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    private boolean solve(int node, ArrayList<ArrayList<Integer>> edges, int[] colors, int n, int m) {
        if (node == n) {
            return true;
        }

        for (int color = 1; color <= m; color++) {
            if (isPossible(node, edges, colors, color)) {
                colors[node] = color;
                if (solve(node + 1, edges, colors, n, m)) {
                    return true;
                }
                colors[node] = 0; // Backtrack
            }
        }
        return false;
    }

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }
            }
        }

        int[] colors = new int[n];
        return solve(0, edges, colors, n, m);
    }
}
