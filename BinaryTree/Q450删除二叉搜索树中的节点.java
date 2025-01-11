package BinaryTree;

public class Q450删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        // 第一种情况，没有找到删除节点，return null
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 第二种情况，删除叶子节点，直接删除
            if (root.left == null && root.right == null) {
                return null;
            }
            // 第三种情况，删除节点只有一个孩子，左孩子, 返回左孩子到上一级，让parent指向root的child
            if (root.left != null && root.right == null) {
                return root.left;
            }
            // 第四种情况，删除节点只有一个孩子，右孩子，和上一个同理
            if (root.left == null && root.right != null) {
                return root.right;
            }
            // 第五种情况，删除节点有两个孩子，找到其直接后继，把需要删除的点的值变成后继的值，然后删除其直接后继
            if (root.left != null && root.right != null) {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
