package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637二叉树的层平均值 {
   public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    if (root == null) {
      return res;
    } 
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int curLevelSize = q.size();
      double curLvlSum = 0.0;
      for (int i = 0; i < curLevelSize; i++) {
        TreeNode curNode = q.poll();
        curLvlSum += curNode.val;
        if (curNode.left != null) {
          q.offer(curNode.left);
        }
        if (curNode.right != null) {
          q.offer(curNode.right);
        }
      }
      res.add(curLvlSum / curLevelSize);
    }
    return res;
  }
}
