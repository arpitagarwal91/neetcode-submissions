class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int cost = prices[0];
        for(int i=0;i<prices.length;i++){
            int profit = prices[i]-cost;
            res = Math.max(res, profit);
            cost = Math.min(cost, prices[i]);
        }
        return res;
    }
}
