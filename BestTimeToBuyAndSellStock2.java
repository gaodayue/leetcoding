public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int profit = 0;
        for (int i=1; i < len; i++) {
            // greed!!
            if (prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
