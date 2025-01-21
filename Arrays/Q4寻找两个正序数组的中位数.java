package Arrays;

public class Q4寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArr = new int[nums1.length + nums2.length];
        int mergePos = 0, ptr1 = 0, ptr2 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length) mergeArr[mergePos++] = nums1[ptr1] < nums2[ptr2] ? nums1[ptr1++] : nums2[ptr2++];
        while (ptr1 < nums1.length) mergeArr[mergePos++] = nums1[ptr1++];
        while (ptr2 < nums2.length) mergeArr[mergePos++] = nums2[ptr2++];
        return (nums1.length + nums2.length) % 2 != 0 ? mergeArr[(nums1.length + nums2.length) / 2] : (mergeArr[(nums1.length + nums2.length) / 2 - 1] + mergeArr[(nums1.length + nums2.length) / 2]) / 2.0;
    }

}
