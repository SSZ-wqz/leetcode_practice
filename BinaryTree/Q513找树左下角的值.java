package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Q513找树左下角的值 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return backTracking(root);
    }

}
