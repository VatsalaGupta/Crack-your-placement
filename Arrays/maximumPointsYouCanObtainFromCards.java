package Arrays;

public class maximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        maximumPointsYouCanObtainFromCards solution = new maximumPointsYouCanObtainFromCards();
        int maxScore = solution.maxScore(cardPoints, k);

        System.out.println("The maximum score you can obtain is: " + maxScore);
    }

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = 0;
        
        // Calculate the initial sum of the first k elements from the start
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int maxSum = sum;

        // Use a sliding window to calculate the sum by taking from the end of the array
        for (int i = 0; i < k; i++) {
            sum = sum - cardPoints[k - 1 - i] + cardPoints[len - 1 - i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
