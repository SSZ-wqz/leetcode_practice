package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author shenweizhang
 */
public class Q515在每个树行中找最大值 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            int curLvlSize = queue.size();
            int curLvlBiggest = Integer.MIN_VALUE;
            for (int i = 0; i < curLvlSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.val > curLvlBiggest) {
                    curLvlBiggest = curNode.val;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(curLvlBiggest);
        }
        return res;
    }
}
