package Greedy;

public class Q53最大子数组和 {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 这两步就是局部最优到全局最优的过程
            if (count > result) { // 如果当前和大于结果，则更新结果
                result = count;
            }
            if (count < 0) { // 如果当前和为负，则重置为0
                count = 0;
            }
        }
        return result;
    }

}
