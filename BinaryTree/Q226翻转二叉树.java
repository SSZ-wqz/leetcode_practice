package BinaryTree;

import java.util.Stack;

public class Q226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curNode = st.pop();
            swap(curNode);
            if (curNode.left != null) {
                st.push(curNode.left);
            }
            if (curNode.right != null) {
                st.push(curNode.right);
            }
        }
        return root;
    }

}
