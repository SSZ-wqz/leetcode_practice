package Backtrace;

public class Q376摆动序列 {

    public int wiggleMaxLength(int[] nums) {
        int result = 1; // 初始化结果为1，因为至少有一个元素
        if (nums.length == 1) {
            return result; // 如果数组长度为1，直接返回结果
        }
        int preDiff = 0; // 前一个差值初始化为0
        int curDiff = 0; // 当前差值初始化为0
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i]; // 计算当前差值
            // 如果当前差值和前一个差值符号相反，则计数加1
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff; // 更新前一个差值为当前差值
            }
        }
        return result; // 返回结果
    }

}
