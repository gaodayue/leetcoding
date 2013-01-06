public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        // firstMax[i] is max profit in prices[0..i]
        int[] firstMax = new int[len];
        firstMax[0] = 0;
        int min = prices[0];
        for (int i=1; i < len; i++) {
            min = Math.min(prices[i], min);
            firstMax[i] = Math.max(prices[i]-min, firstMax[i-1]);
        }
        
        int totalMax = 0;
        // secondMax[i] is max profit in prices[i..n]
        int[] secondMax = new int[len];
        secondMax[len-1] = 0;
        int max = prices[len-1];
        for (int i=len-1; i >= 0; i--) {
            max = Math.max(prices[i], max);
            if (i < len-1)
                secondMax[i] = Math.max(max-prices[i], secondMax[i+1]);
            totalMax = Math.max(firstMax[i]+secondMax[i], totalMax);
        }
        
        return totalMax;
    }
}
