package Backtrace;

import java.util.ArrayList;
import java.util.List;

public class Q17电话号码的字母组合 {

    private List<String> resList = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return resList; // 如果输入为空，直接返回空列表
        }
        backtracking(digits, letterMap, 0);
        return resList;
    }

    private void backtracking(String digits, String[] letterMap, int index) {
        if (index == digits.length()) {
            resList.add(sb.toString());
            return;
        }
        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, letterMap, index + 1);
            sb.deleteCharAt(sb.length() - 1); // 回溯，删除最后一个字符
        }
    }

}
