class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int l = 0, r = 0;
        while(r<prices.length){
            if(prices[r]>prices[l]){
                profit = Math.max(profit, prices[r]-prices[l]);
            }
            else{
                l = r;
            }
            r++;
        }
        return profit;
    }
}
