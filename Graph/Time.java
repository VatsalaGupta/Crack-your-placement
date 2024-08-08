import java.util.ArrayList;

public class Time {
    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = {2, 2, -1, 2, 2, 2};
        int[] informTime = {0, 0, 1, 0, 0, 0};

        Time timeCalculator = new Time();
        int result = timeCalculator.numOfMinutes(n, headID, manager, informTime);
        System.out.println("Total time to inform all employees: " + result);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }

        // Find the maximum time
        return dfs(headID, adj, informTime);
    }

    public int dfs(int manager, ArrayList<ArrayList<Integer>> adj, int[] informTime) {
        int maxTime = 0;
        
        // Traverse all employees under this manager
        for (int emp : adj.get(manager)) {
            int time = dfs(emp, adj, informTime);
            maxTime = Math.max(maxTime, time);
        }
        
        // Add the time needed to inform this manager
        return maxTime + informTime[manager];
    }
}
