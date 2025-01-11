package BinaryTree;

public class Q669修剪二叉搜索树 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果遍历到叶子节点返回上层null
        if (root == null) {
            return null;
        }
        // 如果当前的左面的孩子不符合区间，那么右孩子有可能符合区间
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 如果当前的右面的孩子不符合区间，那么左孩子有可能符合区间
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 连接下层节点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}
