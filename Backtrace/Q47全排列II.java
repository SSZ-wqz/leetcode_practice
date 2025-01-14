package Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 待优化，时间复杂度太高，因为使用set来判断是否重复，时间复杂度太高
public class Q47全排列II {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;
    private Set<List<Integer>> set = new HashSet<>();

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            if (set.contains(path)) {
                return;
            }
            answer.add(new ArrayList<>(path));
            set.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return answer;
        }
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums);
        return answer;
    }

}
