import java.util.Arrays;

public class Job {
    private static final int profit = 0;

    public Job(int i, int j, int k) {
        //TODO Auto-generated constructor stub
    }

    public Job() {
        //TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        int N = 4;
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 1, 40),
            new Job(4, 1, 30)
        };

        Job jobScheduler = new Job();
        int[] result = jobScheduler.JobScheduling(jobs, N);

        System.out.println("Number of jobs done: " + result[0]);
        System.out.println("Total profit: " + result[1]);
    }
    // Job scheduling method
    @SuppressWarnings("static-access")
    int[] JobScheduling(Job arr[], int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // Array to track free time slots
        boolean[] p = new boolean[n + 1];
        int[] res = new int[2]; // res[0] - number of jobs, res[1] - total profit

        for (Job job : arr) {
            for (int i = job.profit; i >= 1; i--) {
                if (!p[i]) {
                    p[i] = true;
                    res[0]++;
                    res[1] += job.profit;
                    break;
                }
            }
        }

        return res;
    }
}
