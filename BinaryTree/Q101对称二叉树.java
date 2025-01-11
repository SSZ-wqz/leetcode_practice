package BinaryTree;

public class Q101对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode leftChild, TreeNode rightChild) {
        if (leftChild == null && rightChild == null) {
            return true;
        }
        if (leftChild == null || rightChild == null) {
            return false;
        }
        if (leftChild.val != rightChild.val) {
            return false;
        }
        return compare(leftChild.left, rightChild.right) && compare(leftChild.right, rightChild.left);
    }
}
