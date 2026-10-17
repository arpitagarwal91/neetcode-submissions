class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        int res = getMinCoins(coins.length-1, coins, amount, dp);
        return res==100000 ? -1 : res;
    }

    private int getMinCoins(int i, int coins[], int amount, int[][] dp){
        if(i==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return 100000;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];

        int notTake = getMinCoins(i-1, coins, amount, dp);
        int take = 100000;
        if(coins[i]<=amount){
            take = 1 + getMinCoins(i, coins, amount-coins[i], dp);
        }
        return dp[i][amount] = Math.min(notTake, take);
    }
}
