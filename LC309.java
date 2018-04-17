class Solution {
    public int maxProfit(int[] prices) {
        //buy[i]: the maximum money to earn if buy on day i
        //buy[i] = max(buy[i - 1], sell[i - 2] - price[i])
        //sell[i]: ...if sell ..
        //sell[i] = max(sell[i - 1], prices[i] + buy[i - 1])
        if (prices.length == 0)
            return 0;
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        int preBuy = -prices[0], preSell = 0;
        for (int i = 1; i < n; i++) {
            buy = Math.max(buy, (i >= 2? preSell : 0) - prices[i]);
            preSell = sell;
            sell = Math.max(sell, prices[i] + preBuy);
            preBuy = buy;
        }
        return Math.max(sell, buy);
    }
}