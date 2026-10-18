class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return getMaxProfit(0, true, prices, dp);
    }

    private int getMaxProfit(int idx, boolean isBuying, int[] prices, int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[isBuying ? 1 : 0][idx]!=-1) return dp[isBuying ? 1 : 0][idx];
        if(isBuying){
            int buy = -prices[idx] + getMaxProfit(idx+1, !isBuying, prices, dp);
            int notBuy = getMaxProfit(idx+1, isBuying, prices, dp);
            return dp[isBuying ? 1 : 0][idx] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[idx] + getMaxProfit(idx+2, !isBuying, prices, dp);
            int notSell = getMaxProfit(idx+1, isBuying, prices, dp);
            return dp[isBuying ? 1 : 0][idx] = Math.max(sell, notSell);
        }
    }
}
