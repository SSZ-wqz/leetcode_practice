package Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40组合总和II {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return resList;
        }
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, used);
        return resList;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int curSum, boolean[] used) {
        if (curSum == target) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (curSum > target) {
                break;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(candidates[i]);
            curSum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, i + 1, curSum, used);
            used[i] = false;
            curSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

}
