package Heap;

import java.util.PriorityQueue;

public class Smallest {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;

        Smallest smallest = new Smallest();
        int result = smallest.kthSmallest(matrix, k);
        System.out.println("The " + k + "-th smallest element is " + result);
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
            }
        }

        while (k-- > 1) {
            pq.poll();
        }

        return pq.poll();
    }
}
