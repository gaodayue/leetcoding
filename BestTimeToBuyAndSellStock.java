public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            int diff = prices[i] - min;
            if (diff > max)
                max = diff;
        }
        return max;
    }
}
