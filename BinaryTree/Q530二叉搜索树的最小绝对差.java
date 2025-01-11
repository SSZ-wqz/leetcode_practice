package BinaryTree;

import java.util.Stack;

public class Q530二叉搜索树的最小绝对差 {

    private TreeNode prev = null;
    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMinimumDifference(root.left);
        if (prev != null && Math.abs(root.val - prev.val) < result) {
            result = Math.abs(root.val - prev.val);
        }
        prev = root;
        int right = getMinimumDifference(root.right);
        return result;
    }

    public int getMinimumDifference2(TreeNode root) {
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if (prev != null && Math.abs(curr.val - prev.val) < result) {
                result = Math.abs(curr.val - prev.val);
            }
            prev = curr;
            root = curr.right;
        }
        return result;
    }

}
