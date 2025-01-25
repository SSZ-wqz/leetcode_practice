package DP;

public class Q746使用最小花费爬楼梯 {

    // dynamic programming
    public int minCostClimbingStairs(int[] cost) {
      // 这里就是如果楼梯只有1层或者2层，那么直接返回最小值
        if (cost.length <= 2) {
            return Math.min(cost[0], cost[1]);
        }
        // 创建一个dp数组，dp[i]表示到达第i层的最小花费
        int[] dp = new int[cost.length + 1];
        // 初始化dp数组，dp[0]和dp[1]都为0，因为从第0层和第1层开始不需要花费
        // 就是只有make movement 的时候才会有花费，如果只是站在那里，那么花费就是0
        dp[0] = 0;
        dp[1] = 0;
        // 遍历dp数组，计算到达每一层的最小花费
        for (int i = 2; i < dp.length; i++) {
            // 计算到达第i层的最小花费，有两种方式：
            // 1. 从第i-2层走两步到第i层，花费为dp[i-2] + cost[i-2]
            // 2. 从第i-1层走一步到第i层，花费为dp[i-1] + cost[i-1]    为什么要加上之前dp的值，就是因为我们要取其sum
            // 取这两种方式的最小值作为dp[i]的值
            int oneStep = dp[i - 2] + cost[i - 2];
            int twpSteps = dp[i - 1] + cost[i - 1];
            dp[i] = Math.min(oneStep, twpSteps);
        }
        return dp[dp.length - 1];
    }

}
