class Solution {
    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][2];
        return getMaxProfit(0, true, prices, dp);
    }

    private int getMaxProfit(int idx, boolean isBuying, int[] prices, Integer dp[][]){
        int y = isBuying ? 0 : 1;
        if(idx>=prices.length) return 0;
        if(dp[idx][y]!=null) return dp[idx][y];

        if(isBuying){
            int buy = -prices[idx] + getMaxProfit(idx+1, !isBuying, prices, dp);
            int notBuy = getMaxProfit(idx+1, isBuying, prices, dp);
            return dp[idx][y] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[idx] + getMaxProfit(idx+2, !isBuying, prices, dp);
            int notSell = getMaxProfit(idx+1, isBuying, prices, dp);
            return dp[idx][y] = Math.max(sell, notSell);
        }
    }
}
