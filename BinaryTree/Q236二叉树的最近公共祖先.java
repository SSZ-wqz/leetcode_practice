package BinaryTree;

public class Q236二叉树的最近公共祖先 {

    // 后序遍历，左右中
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，返回null
        if (root == null) {
            return null;
        }
        // 如果当前节点是p或q，返回当前节点
        if (root == p || root == q) {
            return root;
        }
        // 递归查找左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归查找右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树和右子树都找到了p或q，说明当前节点是最近公共祖先
        if (left != null && right != null) {
            return root;
        } 
        // 如果左子树没有找到，返回右子树的结果
        else if (left == null && right != null) {
            return right;
        } 
        // 如果右子树没有找到，返回左子树的结果
        else if (left != null && right == null) {
            return left;
        } 
        // 如果左右子树都没有找到，返回null
        else {
            return null;
        }
    }

}
