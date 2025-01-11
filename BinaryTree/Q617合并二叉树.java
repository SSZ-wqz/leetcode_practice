package BinaryTree;

public class Q617合并二叉树 {

    // 构造二叉树，前序，中左右
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果期中一个节点为空，直接返回它另一个
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

}
