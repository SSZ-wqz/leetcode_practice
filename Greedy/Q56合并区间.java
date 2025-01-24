package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56合并区间 {

    public int[][] merge(int[][] intervals) {
        List<int[]> tempList = new ArrayList<>();   // 先用list存储结果因为事先不知道resArr的大小
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {   // 也就是这里left boundary和right boundary不是连续的时候
                tempList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        // 这里最后如果是单独的话落了一个
        tempList.add(new int[]{start, end});
        int[][] resArr = new int[tempList.size()][2];
        for (int i = 0; i < tempList.size(); i++) {
            resArr[i][0] = tempList.get(i)[0];
            resArr[i][1] = tempList.get(i)[1];
        }
        return resArr;
    }

}
