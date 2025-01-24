package Greedy;

import java.util.Arrays;

public class Q452用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }

}
