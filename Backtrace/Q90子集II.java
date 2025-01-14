package Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90子集II {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    private void backtracking(int[] nums, int startIndex) {
        resList.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return resList;
        }
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums, 0);
        return resList;
    }

}
