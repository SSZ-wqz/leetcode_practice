package DP;

public class Q509斐波那契数 {

    // 回溯
    public int fib(int n) {
        if (n <= 1) {
          return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 动态规划五部曲：
     *    1. 确定dp数组以及下标含义：dp[i]表示第i个斐波那契数
     *    2. 确定递推公式：dp[i] = dp[i - 1] + dp[i - 2]
     *    3. dp数组初始化：dp[0] = 0, dp[1] = 1
     *    4. 确定遍历顺序：从前到后
     *    5. 打印dp数组：debug
     */
    public int fib_dp(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
