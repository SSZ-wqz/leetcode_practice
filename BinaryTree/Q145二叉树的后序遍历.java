package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Q145二叉树的后序遍历 {
    // 左右中
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    postorder(res, root);
    return res;
  }

  private void postorder(List<Integer> list, TreeNode cur) {
    if (cur != null) {
      postorder(list, cur.left);
      postorder(list, cur.right);
      list.add(cur.val);
    }
  }

  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Stack<TreeNode> st = new Stack<>();
    st.push(root);
    while (!st.isEmpty()) {
      TreeNode cur = st.pop();
      res.add(cur.val);
      if (cur.left != null) {
        st.push(cur.left);
      }
      if (cur.right != null) {
        st.push(cur.right);
      }
    }
    Collections.reverse(res);
    return res;
  }
}
