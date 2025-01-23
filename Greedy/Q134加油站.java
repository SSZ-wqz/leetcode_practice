package Greedy;

public class Q134加油站 {

    // 暴力解法
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTank;    // 初始油桶
        int result = -1;
        for (int i = 0; i < gas.length; i++) {    // 开始尝试gas数组中每一个点是否能成为起始位置
            if (gas[i] < cost[i]) {    // 如果油桶里的油比cost要小，那么不能成为起始点
                continue;
            }
            int startIndex = i;    // 定义初始位置
            int cnt = gas.length;   // 需要循环的次数从而遍历一周
            gasTank = gas[startIndex];   // 初始化油箱的油
            boolean canComplete = true;
            while (cnt > 0) {
                int prevIndex = startIndex;
                gasTank = gasTank - cost[prevIndex];
                if (gasTank < 0) {
                    canComplete = false;
                    break;
                }
                startIndex = (startIndex + 1) % gas.length;
                gasTank = gasTank + gas[startIndex];
                --cnt;
            }
            if (canComplete) {
                return i;
            }
        }
        return result;
    }

    /**
     * 贪心算法（方法一） 直接从全局进行贪心选择，情况如下：
     *
     * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
     *
     * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，
     * 说明从0出发，油就没有断过，那么0就是起点。
     *
     * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平， 能把这个负数填平的节点就是出发节点。
     */
    public int canCompleteCircuit_Greedy1(int[] gas, int[] cost) {
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            curSum += rest;
            if (curSum < min) {   // min 是负数最小值
                min = curSum;
            }
        }
        // 情况一
        if (curSum < 0) {
            return -1;
        }
        // 情况二
        if (min >= 0) {
            return 0;
        }
        // 情况三
        for (int i = gas.length - 1; i >= 0; i--) {
            int rest = gas[i] - cost[i];
            min += rest;
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 贪心算法（方法二） 可以换一个思路，首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈， 说明 各个站点的加油站
     * 剩油量rest[i]相加一定是大于等于零的。
     *
     * 每个加油站的剩余量rest[i]为gas[i] - cost[i]。
     *
     * i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，
     * 因为这个区间选择任何一个位置作为起点，到i这里都会断油， 那么起始位置从i+1算起，再从0计算curSum。
     */
    public int canCompleteCircuit_Greedy2(int[] gas, int[] cost) {
        int start = 0;
        int curSum = 0;
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum = curSum + gas[i] - cost[i];
            totalSum = totalSum + gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }

}
