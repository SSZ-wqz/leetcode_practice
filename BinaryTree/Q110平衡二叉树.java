package BinaryTree;


public class Q110平衡二叉树 {

  public boolean isBalanced(TreeNode root) {
    return getHeight(root) != -1;
  }  

  private int getHeight(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }
    int leftHeight = getHeight(treeNode.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = getHeight(treeNode.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }

}
