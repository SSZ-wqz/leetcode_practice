package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q763划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> resList = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();      // Key存字母，Value存[start, end]
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new int[]{i, s.lastIndexOf(s.charAt(i))});
            }
        }
        // 把hashmap的值放到二维数组中
        int[][] intervals = new int[map.size()][2];    // 定义二维数组来存储所有的区间，eg: [[1,2],[4,5]...]
        int index = 0;
        for (Map.Entry<Character, int[]> mapEle : map.entrySet()) {
            int start = mapEle.getValue()[0];
            int end = mapEle.getValue()[1];
            intervals[index][0] = start;
            intervals[index][1] = end;
            ++index;
        }
        // 排序它
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int startIndex = intervals[0][0];
        int endIndex = intervals[0][1];
        // Greedy algorithm to search for the max and min boundary
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > endIndex) {
                resList.add(endIndex - startIndex + 1);
                startIndex = intervals[i][0];
                endIndex = intervals[i][1];
            } else {
                startIndex = Math.min(startIndex, intervals[i][0]);
                endIndex = Math.max(endIndex, intervals[i][1]);
            }
        }
        resList.add(endIndex - startIndex + 1);
        return resList;
    }

}
