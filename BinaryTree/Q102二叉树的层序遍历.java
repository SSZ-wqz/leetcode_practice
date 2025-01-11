package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102二叉树的层序遍历 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int currentLevelSize = q.size();
      List<Integer> currentLevelList = new ArrayList<>();
      while (currentLevelSize-- > 0) {
        TreeNode curNode = q.poll();
        currentLevelList.add(curNode.val);
        if (curNode.left != null) {
          q.offer(curNode.left);
        }
        if (curNode.right != null) {
          q.offer(curNode.right);
        }
      }
      res.add(currentLevelList);
    }
    return res;
  }
}
