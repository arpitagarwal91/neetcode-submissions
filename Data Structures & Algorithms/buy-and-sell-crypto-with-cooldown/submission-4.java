class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return maxProfitCooldown(0, prices, true, dp);
    }

    public int maxProfitCooldown(int idx, int[] prices, boolean isBuying, int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[isBuying?0:1][idx]!=-1) return dp[isBuying?0:1][idx];
        //int res = 0;
        if(isBuying){
            int buy = -prices[idx]+maxProfitCooldown(idx+1, prices, !isBuying, dp);
            int notBuy = maxProfitCooldown(idx+1, prices, isBuying, dp);
            dp[isBuying?0:1][idx] = Math.max(buy, notBuy);
        }
        else{
            int sell = prices[idx]+maxProfitCooldown(idx+2, prices, !isBuying, dp);
            int notSell = maxProfitCooldown(idx+1, prices, isBuying, dp);
            dp[isBuying?0:1][idx] = Math.max(sell, notSell);
        }
        return dp[isBuying?0:1][idx];
    }
}
