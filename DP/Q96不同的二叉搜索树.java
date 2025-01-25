package DP;

public class Q96不同的二叉搜索树 {

    /**
     * n为1的时候有一棵树，n为2有两棵树，这个是很直观的。 来看看n为3的时候，有哪几种情况。
     *
     *      当1为头结点的时候，其右子树有两个节点，看这两个节点的布局，是不是和 n 为2的时候两棵树的布局是一样的啊！
     *
     *      （可能有同学问了，这布局不一样啊，节点数值都不一样。别忘了我们就是求不同树的数量，并不用把搜索树都列出来，所以不用关心其具体数值的差异）
     *
     *      当3为头结点的时候，其左子树有两个节点，看这两个节点的布局，是不是和n为2的时候两棵树的布局也是一样的啊！
     *
     *      当2为头结点的时候，其左右子树都只有一个节点，布局是不是和n为1的时候只有一棵树的布局也是一样的啊！
     *
     *      发现到这里，其实我们就找到了重叠子问题了，其实也就是发现可以通过dp[1] 和 dp[2] 来推导出来dp[3]的某种方式。
     *
     *      思考到这里，这道题目就有眉目了。
     *
     *      dp[3]，就是 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
     *
     *      元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量
     *
     *      元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
     *
     *      元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
     *
     *      有2个元素的搜索树数量就是dp[2]。
     *
     *      有1个元素的搜索树数量就是dp[1]。
     *
     *      有0个元素的搜索树数量就是dp[0]。
     *
     *      所以dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
     *
     */
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= i - 1; j++) {
                sum = sum + dp[j] * dp[i - 1 - j];
                dp[i] = sum;
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }

}
