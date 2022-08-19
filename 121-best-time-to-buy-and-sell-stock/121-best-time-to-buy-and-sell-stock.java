class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            int difference = 0;
            lowest = Math.min(lowest, prices[i]);
            difference = prices[i] - lowest;
            maxProfit = Math.max(difference, maxProfit);
        }
        
        return maxProfit;
    }
}