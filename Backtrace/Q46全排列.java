package Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46全排列 {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    // 使用used数组来做重新排序，因此在排列题型中不需要startIndex
    private void backtracking(int nums[]) {
        if (path.size() == nums.length) {
            resList.add(new ArrayList<>(path));  // shallow copy path into the resList
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {         // 不是用startIndex，而是每次遍历一遍数组，在used数组中找到空白位置添加
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return resList;
        }
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums);
        return resList;
    }

}
