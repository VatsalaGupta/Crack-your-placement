package Greedy;

import java.util.*;

public class ChocolateBreaking {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = Integer.parseInt(scanner.nextLine().trim());
            
            for (int t = 0; t < testCases; t++) {
                if (t > 0) {
                    scanner.nextLine(); // skip blank line between test cases
                }
                
                String[] dimensions = scanner.nextLine().split(" ");
                int m = Integer.parseInt(dimensions[0]);
                int n = Integer.parseInt(dimensions[1]);
                
                int[] xCosts = new int[m - 1];
                int[] yCosts = new int[n - 1];
                
                for (int i = 0; i < m - 1; i++) {
                    xCosts[i] = Integer.parseInt(scanner.nextLine().trim());
                }
                
                for (int i = 0; i < n - 1; i++) {
                    yCosts[i] = Integer.parseInt(scanner.nextLine().trim());
                }
                
                int result = minimalChocolateBreakCost(m, n, xCosts, yCosts);
                System.out.println(result);
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static int minimalChocolateBreakCost(int m, int n, int[] xCosts, int[] yCosts) {
        Arrays.sort(xCosts);
        Arrays.sort(yCosts);
        
        int xIdx = xCosts.length - 1;
        int yIdx = yCosts.length - 1;
        
        int horizontalPieces = 1;
        int verticalPieces = 1;
        
        int totalCost = 0;
        
        while (xIdx >= 0 && yIdx >= 0) {
            if (xCosts[xIdx] >= yCosts[yIdx]) {
                totalCost += xCosts[xIdx] * horizontalPieces;
                verticalPieces++;
                xIdx--;
            } else {
                totalCost += yCosts[yIdx] * verticalPieces;
                horizontalPieces++;
                yIdx--;
            }
        }
        
        while (xIdx >= 0) {
            totalCost += xCosts[xIdx] * horizontalPieces;
            xIdx--;
        }
        
        while (yIdx >= 0) {
            totalCost += yCosts[yIdx] * verticalPieces;
            yIdx--;
        }
        
        return totalCost;
    }
}
