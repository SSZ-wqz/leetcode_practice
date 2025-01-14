package Backtrace;

import java.util.ArrayList;
import java.util.List;

// 待优化，时间复杂度太高，因为使用set来判断是否重复，时间复杂度太高
public class Q78子集 {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return resList;
        }
        backTracking(nums, 0);
        return resList;
    }

    private void backTracking(int[] nums, int startIndex) {
        resList.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
