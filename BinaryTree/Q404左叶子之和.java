package BinaryTree;

import java.util.Stack;

public class Q404左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sbssy = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sbssy += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sbssy;
    }




    
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return backTracking(root);
    }

    // preorder 中左右 
    private int backTracking(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }
        sum += backTracking(node.left);
        sum += backTracking(node.right);
        return sum;
    }
}
