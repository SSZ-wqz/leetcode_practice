package Backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51N皇后 {

    private final List<List<String>> resList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return resList;
        }
        char[][] chessTable = new char[n][n];
        for (char[] row : chessTable) {
            Arrays.fill(row, '.');
        }
        backTracking(n, chessTable, 0);
        return resList;
    }

    private void backTracking(int n, char[][] chessTable, int row) {
        if (row == n) {
            resList.add(arrayToList(chessTable));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(n, chessTable, row, col)) {
                chessTable[row][col] = 'Q';
                backTracking(n, chessTable, row + 1);
                chessTable[row][col] = '.';
            }
        }
    }

    private List<String> arrayToList(char[][] chessTable) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessTable) {
            list.add(new String(c));
        }
        return list;
    }

    private boolean isValid(int n, char[][] chessTable, int row, int col) {
        // 纵向向上检查
        for (int i = row - 1; i >= 0; i--) {
            if (chessTable[i][col] == 'Q') {
                return false;
            }
        }
        // 斜向向上45°检查
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessTable[i][j] == 'Q') {
                return false;
            }
        }
        // 斜向向上135°检查
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessTable[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
