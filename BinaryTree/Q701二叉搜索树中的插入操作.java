package BinaryTree;

public class Q701二叉搜索树中的插入操作 {

    // 迭代法  
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode prev = root;
        TreeNode curr = root;
        // 找到合适位置
        while (curr != null) {
            prev = curr;
            if (curr.val > val) {
                curr = curr.left;
            } else if (curr.val < val) {
                curr = curr.right;
            }
        }
        // prev节点连接curr(TreeNode)
        curr = new TreeNode(val);
        if (prev.val > val) {
            prev.left = curr;
        } else if (prev.val < val) {
            prev.right = curr;
        }
        return root;
    }

    // 递归法
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // 使用父节点
    private TreeNode previous;

    private void traversal(TreeNode curr, int val) {
        if (curr == null) {
            if (previous.val > val) {
                previous.left = new TreeNode(val);
            } else if (previous.val < val) {
                previous.right = new TreeNode(val);
            }
            return;
        }
        previous = curr;
        if (curr.val > val) {
            traversal(curr.left, val);
        } else if (curr.val < val) {
            traversal(curr.right, val);
        }
    }

    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        this.previous = root;
        traversal(root, val);
        return root;
    }

}
