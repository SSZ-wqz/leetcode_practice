package Backtrace;

import java.util.ArrayList;
import java.util.List;

public class Q131分割回文串 {

    private List<List<String>> resList = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return resList;
        }
        backtracking(s, 0);
        return resList;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (check(sub) == true) {
                path.add(sub);
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean check(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
