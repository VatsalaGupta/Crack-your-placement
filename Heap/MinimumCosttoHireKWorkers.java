package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;

        MinimumCosttoHireKWorkers solution = new MinimumCosttoHireKWorkers();
        double result = solution.mincostToHireWorkers(quality, wage, k);

        System.out.println("Minimum cost to hire " + k + " workers: " + result);
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<double[]> workers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            workers.add(new double[]{(double) wage[i] / quality[i], (double) quality[i]});
        }
        
        workers.sort(Comparator.comparingDouble(a -> a[0]));
        
        double ans = Double.MAX_VALUE;
        double qualitySum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (double[] worker : workers) {
            double ratio = worker[0];
            qualitySum += worker[1];
            pq.offer(worker[1]);
            
            if (pq.size() > k) {
                qualitySum -= pq.poll();
            }
            
            if (pq.size() == k) {
                ans = Math.min(ans, qualitySum * ratio);
            }
        }

        return ans;
    }
}
