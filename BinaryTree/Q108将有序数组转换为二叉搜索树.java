package BinaryTree;

public class Q108将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }

        int middleIndex = start + ((end - start) / 2);
        TreeNode root = new TreeNode(nums[middleIndex]);

        int leftStart = start;
        int leftEnd = middleIndex;
        int rightStart = middleIndex + 1;
        int rightEnd = end;

        root.left = construct(nums, leftStart, leftEnd);
        root.right = construct(nums, rightStart, rightEnd);

        return root;
    }

}
