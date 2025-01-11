package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int curLevelSize = q.size();
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode curNode = q.poll();
        if (i == curLevelSize - 1) {
          res.add(curNode.val);
        }
        if (curNode.left != null) {
          q.offer(curNode.left);
        }
        if (curNode.right != null) {
          q.offer(curNode.right);
        }
      }
    }
    return res;
  }
}
