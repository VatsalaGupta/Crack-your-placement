package Greedy;

import java.util.Arrays;

public class scheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        scheduler scheduler = new scheduler();
        int result = scheduler.leastInterval(tasks, n);
        System.out.println("Least number of intervals: " + result);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        // Count frequency of each task
        for (char c : tasks) {
            taskFreq[c - 'A']++;
        }
        // Sort the frequencies
        Arrays.sort(taskFreq);
        // Get the maximum frequency
        int maxFreq = taskFreq[25];
        // Calculate the number of idle slots
        int idleSlots = (maxFreq - 1) * n;
        // Fill the idle slots with other tasks
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(taskFreq[i], maxFreq - 1);
        }
        // If there are still idle slots, add them to the total length, otherwise return the length of tasks
        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}
