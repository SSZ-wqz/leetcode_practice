package Backtrace;

import java.util.ArrayList;
import java.util.List;

public class Q39组合总和 {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return resList;
        }
        backtracking(candidates, target, 0, 0);
        return resList;
    }

    private void backtracking(int[] candidates, int target, int index, int curSum) {
        if (curSum == target) {
            resList.add(new ArrayList<>(path));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            curSum += candidates[i];
            backtracking(candidates, target, i, curSum);
            curSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

}
