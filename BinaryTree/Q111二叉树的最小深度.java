package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Q111二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSide = minDepth(root.left);
        int rightSide = minDepth(root.right);
        if (root.left == null) {
            return 1 + rightSide;
        }
        if (root.right == null) {
            return 1 + leftSide;
        }
        return 1 + Math.min(leftSide, rightSide);
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return minDepth;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }



    // 回溯法
    private int maxDepth = Integer.MIN_VALUE;
    private int resVal = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root, 0);
        return this.resVal;
    }

    // find the bottom left, we use postorder traversal, 左右中 
    private void traversal(TreeNode node, int curDepth) {
        if (node == null) {
            return;
        }        
        if (node.left != null) {    // 左
            curDepth++;
            traversal(node.left, curDepth);
            curDepth--;   // 回溯
        }
        if (node.right != null) {    // 右
            curDepth++;
            traversal(node.right, curDepth);
            curDepth--;   // 回溯
        }
        if (node.left == null && node.right == null) {  // 中 叶子节点
            if (curDepth > this.maxDepth) {
                this.maxDepth = curDepth;
                this.resVal = node.val;
            }
            return;   // 碰到第一个叶子节点直接return以确保获得的某一特定层数的最左面
        }
    }  

}
