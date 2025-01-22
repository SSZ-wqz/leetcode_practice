package Greedy;

public class Q122买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = 0;
        int sell = 0;
        int currDiff = 0;
        int preDiff = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            currDiff = prices[i + 1] - prices[i];
            if (preDiff <= 0 && currDiff > 0) {
                buy = i;
            }
            if (preDiff > 0 && currDiff <= 0) {
                sell = i;
                profit += prices[sell] - prices[buy];
            }
            preDiff = currDiff;
        }
        if (preDiff > 0) {
            profit += prices[prices.length - 1] - prices[buy];
        }
        return profit;
    }

}
