package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107二叉树的层次遍历II {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> res = new LinkedList<>();     // 使用头插，O(1)
    if (root == null) {
      return res;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int curLevelSize = q.size();
      List<Integer> curLevelList = new ArrayList<>();
      while (curLevelSize-- > 0) {
        TreeNode curNode = q.poll();
        curLevelList.add(curNode.val);
        if (curNode.left != null) {
          q.offer(curNode.left);
        }
        if (curNode.right != null) {
          q.offer(curNode.right);
        }
      }
      res.addFirst(curLevelList); 
    }
    return res;
  }
}
