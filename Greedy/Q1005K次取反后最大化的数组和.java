package Greedy;

import java.util.Arrays;

public class Q1005K次取反后最大化的数组和 {

    // 1. 将数组排序
    // 2. 把所有最小的值都翻转过来
    // 3，如果k有剩余，就一直翻转最小的正数
    // 4. 求和
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] *= -1;
                --k;
            }
        }
        if (k % 2 != 0) {
            Arrays.sort(nums);
            nums[0] *= -1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
