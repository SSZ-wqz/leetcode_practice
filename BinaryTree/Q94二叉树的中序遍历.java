
package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94二叉树的中序遍历 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    return res;
  }

  private void inorder(TreeNode cur, List<Integer> list) {
    if (cur != null) {
      inorder(cur.left, list);
      list.add(cur.val);
      inorder(cur.right, list);
    }
  }

  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Stack<TreeNode> st = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !st.isEmpty()) {
      if (cur != null) {
        st.push(cur);
        cur = cur.left;
      } else {
        cur = st.pop();
        res.add(cur.val);
        cur = cur.right;
      }
    }
    return res;
  }
}
