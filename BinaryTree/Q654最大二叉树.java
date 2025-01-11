package BinaryTree;

public class Q654最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length);
    }

    // 构建二叉树，中左右，前序遍历
    private TreeNode construct(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }

        int maxVal = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[maxVal]) {
                maxVal = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxVal]);

        int newLeftStart = left;
        int newLeftEnd = maxVal;

        int newRightStart = maxVal + 1;
        int newRightEnd = right;

        root.left = construct(nums, newLeftStart, newLeftEnd);
        root.right = construct(nums, newRightStart, newRightEnd);

        return root;
    }

}
