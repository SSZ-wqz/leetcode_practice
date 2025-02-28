package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q257二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Object> st = new Stack<>();
        st.push(root);  // node
        st.push(root.val + "");  // path
        while (!st.isEmpty()) {
            String path = (String) st.pop();
            TreeNode node = (TreeNode) st.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.left != null) {
                st.push(node.left);
                st.push(path + "->" + node.left.val);
            }
            if (node.right != null) {
                st.push(node.right);
                st.push(path + "->" + node.right.val);
            }
        }
        return res;
    }


    public List<String> binaryTreePaths2(TreeNode root) {
      List<String> res = new ArrayList<>();// 存最终的结果
      if (root == null) {
          return res;
      }
      List<Integer> paths = new ArrayList<>();// 作为结果中的路径
      traversal(root, paths, res);
      return res;
  }

  private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
      paths.add(root.val);// 前序遍历，中
      // 遇到叶子结点
      if (root.left == null && root.right == null) {
          // 输出
          StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
          for (int i = 0; i < paths.size() - 1; i++) {
              sb.append(paths.get(i)).append("->");
          }
          sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
          res.add(sb.toString());// 收集一个路径
          return;
      }
      // 递归和回溯是同时进行，所以要放在同一个花括号里
      if (root.left != null) { // 左
          traversal(root.left, paths, res);
          paths.remove(paths.size() - 1);// 回溯
      }
      if (root.right != null) { // 右
          traversal(root.right, paths, res);
          paths.remove(paths.size() - 1);// 回溯
      }
  }

}
