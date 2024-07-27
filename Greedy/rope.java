package Greedy;

public class rope {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        
        rope solution = new rope();
        int result = solution.minCost(colors, neededTime);
        System.out.println(result);
    }
    
    public int minCost(String s, int[] neededTime) {
        int sum = 0;  // Total cost to be computed
        char curr = s.charAt(0);  // Current character being checked
        int maxTime = neededTime[0];  // Maximum time for the current character sequence
        
        for (int i = 1; i < neededTime.length; i++) {
            if (curr == s.charAt(i)) {  // If current character is same as the previous one
                if (neededTime[i] > maxTime) {
                    sum += maxTime;  // Add the maximum time of the previous sequence
                    maxTime = neededTime[i];  // Update maxTime to the current one
                } else {
                    sum += neededTime[i];  // Add the current time to the total cost
                }
            } else {
                curr = s.charAt(i);  // Update the current character
                maxTime = neededTime[i];  // Update maxTime for the new character sequence
            }
        }
        return sum;  // Return the total minimum cost
    }
}
