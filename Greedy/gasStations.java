package Greedy;

import java.util.Arrays;

public class gasStations {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        
        gasStations gs = new gasStations();
        int startingStation = gs.canCompleteCircuit(gas, cost);
        System.out.println("Starting station: " + startingStation);
    }

    boolean canSolve(int i, int gas[], int cost[]) {
        int maxStart = i; // Initialize the starting point
        int fuel = 0; // Initialize fuel available
        int n = cost.length; // Length of the gas/cost arrays
        do {
            fuel += gas[i % n]; // Adding gas at station i (wrap around if needed)
            if (fuel < cost[i % n]) { // Check if fuel is insufficient to reach station i
                return false; // If so, return false
            }
            fuel -= cost[i % n]; // Deduct the cost of travel from station i
            i = (i + 1) % n; // Move to the next station (wrap around if needed)
        } while (i != maxStart); // Continue until we return to the starting point
        return true; // If we can complete the circuit, return true
    }

    // Main method to find the starting station to complete the circuit
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // Total gas available
        int totalCost = 0; // Total cost of travel
        
        // Loop through the stations
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i]; // Accumulate total gas
            totalCost += cost[i]; // Accumulate total cost
        }
        
        // If total gas < total cost, return -1
        if (totalGas < totalCost) {
            return -1;
        }
        
        // Create a 2D array to store gas, cost, and station index
        int arr[][] = new int[gas.length][3];
        
        // Populate the array with gas, cost, and station index
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = gas[i];
            arr[i][1] = cost[i];
            arr[i][2] = i;
        }
        
        // Sort the array based on the difference between gas and cost
        Arrays.sort(arr, (a, b) -> {
            if (a[0] - a[1] == b[0] - b[1]) {
                return a[1] - b[1];
            } else {
                return (b[0] - b[1]) - (a[0] - a[1]);
            }
        });
        
        // Iterate through the sorted array
        for (int[] row : arr) {
            // If starting from the current station, we can complete the circuit, return the station index
            if (canSolve(row[2], gas, cost)) {
                return row[2];
            }
        }
        
        // If no solution is found, return -1
        return -1;
    }
}
