package Greedy;

import java.util.Arrays;

public class Q435无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int result = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                result++;
                end = Math.min(end, intervals[i][1]);   // 判断保留那个右边界，保留短的因为我们要保留没有overlap的边界
            } else {
                end = intervals[i][1];  // 不重叠的话，更新end
            }
        }
        return result;
    }
}
