package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q98验证二叉搜索树 {

  // 中序遍历，如果遍历结果是递增的，则说明是二叉搜索树 -- 超级无敌纯笨方法只有ssy能想到 sbssy
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }


    private TreeNode prev;

    // 递归：中序，左中右
    public boolean isValidBST2(TreeNode root) {     // 中序遍历，如果遍历结果是递增的，则说明是二叉搜索树 聪明办法只有zsw能想到
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        // 中: 因为左面的永远比中间的小
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        // 右
        boolean right = isValidBST(root.right);
        return left && right;
    }

    // 迭代：中序，左中右
    public boolean isValidBST3(TreeNode root) {       // 中序遍历，如果遍历结果是递增的，则说明是二叉搜索树 聪明办法只有zsw能想到
      if (root == null) {
          return true;
      }
      Stack<TreeNode> stack = new Stack<>();
      TreeNode prev = null;
      while (root != null || !stack.isEmpty()) {
          while (root != null) {
              stack.push(root);
              root = root.left;
          }
          TreeNode curr = stack.pop();
          if (prev != null && prev.val >= curr.val) {
              return false;
          }
          prev = curr;
          root = curr.right;
      }
      return true;
  }

}
