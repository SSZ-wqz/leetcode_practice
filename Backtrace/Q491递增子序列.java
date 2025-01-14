package Backtrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q491递增子序列 {

    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            resList.add(new ArrayList<>(path));
        }
        Set<Integer> used = new HashSet<>(); // Local set to avoid duplicates at this level
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue; // Ensure non-decreasing order
            }
            if (used.contains(nums[i])) {
                continue; // Skip duplicate elements at this level
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1); // Backtrack
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return resList;
    }

}
