package BinaryTree;

public class Q124二叉树中的最大路径和 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        // 当遍历到空节点
        if (node == null) {
            return 0;
        }
        // 递归计算左右子树的最大路径和，负数视为 0
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // 更新最大路径和，路径可以经过当前节点并且包含左右子树
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);

        // 返回当前节点的贡献值，即包含当前节点且只能向左或向右延伸的路径和
        return node.val + Math.max(leftMax, rightMax);
    }

}
