package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder_helper(root, res);
        return res;
    }

    private void preorder_helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorder_helper(root.left, list);
            preorder_helper(root.right, list);
        }
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res; // Handle the case where the tree is empty
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            res.add(cur.val);
            if (cur.right != null) {
                st.push(cur.right);
            }
            if (cur.left != null) {
                st.push(cur.left);
            }
        }
        return res;
    }

}
