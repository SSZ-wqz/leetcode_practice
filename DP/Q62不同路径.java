package DP;

public class Q62不同路径 {

    // dfs -- 超时
    public int uniquePaths(int m, int n) {
        int right = 1;   // 定义起始点，都是1 因为最少是1x1的
        int down = 1;
        return dfs(m, n, right, down);
    }

    // 使用中左右遍历策略，因为有可能 m == 1 && n == 1 
    private int dfs(int m, int n, int i, int j) {
        if (i == n && j == m) {   // 如果找到一种策略返回1
            return 1;
        }
        if (i > n || j > m) {  // 如果遍历超出格子返回0
            return 0;
        }
        int right = dfs(m, n, i + 1, j);  // 向下和向右探索
        int down = dfs(m, n, i, j + 1);
        return right + down;
    }

    // dynamic programming
    public int uniquePaths_dp(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

}
