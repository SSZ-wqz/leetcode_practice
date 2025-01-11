package BinaryTree;

import java.util.Stack;

public abstract class Q112路径总和 {

    // 迭代法
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val);
        while (!stack.isEmpty()) {
            Integer pathSum = (Integer) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if (node.left == null && node.right == null && pathSum == targetSum) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
                stack.push(pathSum + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(pathSum + node.left.val);
            }
        }
        return false;
    }

    // 回溯法 使用前序遍历 中左右
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum, root.val);
    }

    private boolean traversal(TreeNode node, int targetSum, int curSum) {
        // 如果到达了叶子节点并且路径和等于目标值
        if (node.left == null && node.right == null) {
            return curSum == targetSum;
        }

        // 判断左子树
        if (node.left != null) {
            if (traversal(node.left, targetSum, curSum + node.left.val)) {
                return true;
            }
        }

        // 判断右子树
        if (node.right != null) {
            if (traversal(node.right, targetSum, curSum + node.right.val)) {
                return true;
            }
        }

        // 如果左右子树都不满足条件，返回 false
        return false;
    }

}
