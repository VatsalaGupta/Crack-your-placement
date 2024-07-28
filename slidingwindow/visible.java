package slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class visible {
    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(List.of(2, 1));
        points.add(List.of(2, 2));
        points.add(List.of(3, 3));

        int angle = 90;
        List<Integer> location = List.of(1, 1);

        visible obj = new visible();
        int result = obj.visiblePoints(points, angle, location);
        System.out.println("The number of visible points is: " + result);
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int overlap = 0;
        List<Double> list = new ArrayList<>(points.size());
        for (List<Integer> p : points) {
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) {
                overlap++;
            } else {
                list.add(angle(p.get(1) - location.get(1), 
                               p.get(0) - location.get(0)));
            }
        }
        Collections.sort(list);
        int max = 0;
        int n = list.size();
        int i2 = 0;
        for (int i1 = 0; i1 < n; i1++) {
            while ((i2 < n && list.get(i2) - list.get(i1) <= angle) || 
                   (i2 >= n && 360 + list.get(i2 % n) - list.get(i1) <= angle)) {
                i2++;
            }
            max = Math.max(max, i2 - i1);        
        }
        return max + overlap;
    }
    
    private double angle(int dy, int dx) {
        double a = Math.toDegrees(Math.atan2(dy, dx));
        return (a < 0 ? a + 360 : a);
    }
}
