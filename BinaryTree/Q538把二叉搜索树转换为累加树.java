package BinaryTree;

public class Q538把二叉搜索树转换为累加树 {

    private TreeNode prev;
    
    private void traverse(TreeNode curr) {
        if (curr == null) {
            return;
        }
        traverse(curr.right);
        if (prev != null) {
            curr.val += prev.val;
        }
        prev = curr;
        traverse(curr.left);
    }

    // 反中序，右中左
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        return root;
    }

}
