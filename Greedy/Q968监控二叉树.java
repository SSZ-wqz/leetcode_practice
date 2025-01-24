package Greedy;

public class Q968监控二叉树 {

    /**
     * 贪心算法:
     * 后序遍历（左右中），因为要先处理完子节点，再处理父节点
     * 0：无覆盖
     * 1：有摄像头
     * 2：有覆盖
     * 
     * 叶子节点return 2，表示有覆盖
     * 
     * 1. 左右节点都有覆盖，则当前节点return 0，表示无覆盖
     * 2. 左右节点至少有一个无覆盖，则当前节点return 1，表示有摄像头
     * 3. 左右节点至少有一个有摄像头，则当前节点return 2，表示有覆盖
     * 4. 根节点无覆盖，则currNode = 1，result++
     */

    private int result = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (traversal(root) == 0) {
            result++;
        }
        return result;
    }

    private int traversal(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int left = traversal(node.left);
        int right = traversal(node.right);
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 0 || right == 0) {
            result++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }

}
