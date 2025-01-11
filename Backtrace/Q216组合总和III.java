package Backtrace;

import java.util.List;
import java.util.ArrayList;

public class Q216组合总和III {
  
  private List<List<Integer>> resList = new ArrayList<>();
  private List<Integer> path = new ArrayList<>();

  public List<List<Integer>> combinationSum3(int k, int n) {
      backtracking(k, n, 1, 0);
      return resList;
  }

  private void backtracking(int k, int n, int startIndex, int curSum) {
      if (path.size() == k && curSum == n) {
          resList.add(new ArrayList<>(path));
          return;
      }
      for (int i = startIndex; i <= 9; i++) {
          path.add(i);
          if (curSum < n) {
              backtracking(k, n, i + 1, curSum += i);
          }
          curSum -= i;
          path.removeLast();
      }
  }

}
