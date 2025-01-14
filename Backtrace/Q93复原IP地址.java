package Backtrace;

import java.util.ArrayList;
import java.util.List;

public class Q93复原IP地址 {

    private List<String> resList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return resList;
        }
        backtracking(s, new StringBuilder(), 0, 0);
        return resList;
    }

    private void backtracking(String s, StringBuilder sb, int startIndex, int pointSum) {
        if (pointSum == 3) {
            if (isValid(s, startIndex, s.length())) {
                sb.append(s.substring(startIndex));
                resList.add(sb.toString());
                sb.delete(sb.length() - (s.length() - startIndex), sb.length());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i + 1)) {
                String sub = s.substring(startIndex, i + 1);
                sb.append(sub);
                sb.append(".");
                pointSum += 1;
                backtracking(s, sb, i + 1, pointSum);
                pointSum -= 1;
                sb.delete(sb.length() - (sub.length() + 1), sb.length());  // Remove `sub.`
            } else {
                break;
            }
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (end > s.length()) {
            return false;
        }
        String sub = s.substring(start, end);
        if (sub.length() > 3 || sub.length() <= 0) {
            return false;
        }
        if (sub.charAt(0) == '0' && sub.length() > 1) {
            return false;
        }
        if (Integer.parseInt(sub) > 255 || Integer.parseInt(sub) < 0) {
            return false;
        }
        return true;
    }

}
