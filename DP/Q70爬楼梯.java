package DP;

public class Q70爬楼梯 {

    // backtracking
    private int ways = 0;

    public int climbStairs(int n) {
        backtracking(n, 0);
        return ways;
    }

    private void backtracking(int n, int steps) {
        if (n == steps) {
            ++ways;
            return;
        }
        if (steps > n) {
            return;
        }
        for (int i = 1; i <= 2; i++) {
            steps += i;
            backtracking(n, steps);
            steps -= i;
        }
    }

    // dynamic programming
    public int climbStairs_dp(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1]; // 创建大小为 n+1 的数组，表示从 0 到 n 的状态。
        dp[1] = 1; // 爬到第 1 阶的方法只有一种。
        dp[2] = 2; // 爬到第 2 阶的方法有两种：1+1 或直接 2。
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
