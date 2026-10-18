class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            int profit = prices[i] - cost;
            maxProfit = Math.max(maxProfit, profit);
            cost = Math.min(cost, prices[i]);
        }
        return maxProfit;
    }
}
