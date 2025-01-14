package Arrays;

public class Q88合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeArr = new int[nums1.length];
        int mergePos = 0;
        int ptr1 = 0;
        int ptr2 = 0;

        // 合并两个数组的有效部分
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] < nums2[ptr2]) {
                mergeArr[mergePos] = nums1[ptr1];
                ptr1++;
            } else {
                mergeArr[mergePos] = nums2[ptr2];
                ptr2++;
            }
            mergePos++;
        }

        // 把 nums1 剩余的部分复制进 mergeArr
        while (ptr1 < m) {
            mergeArr[mergePos] = nums1[ptr1];
            ptr1++;
            mergePos++;
        }

        // 把 nums2 剩余的部分复制进 mergeArr
        while (ptr2 < n) {
            mergeArr[mergePos] = nums2[ptr2];
            ptr2++;
            mergePos++;
        }

        // 将 mergeArr 的内容复制回 nums1
        for (int i = 0; i < mergeArr.length; i++) {
            nums1[i] = mergeArr[i];
        }
    }

}
