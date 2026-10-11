class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        int res = getMinCoins(coins.length-1, coins, amount, dp);
        return res==100000 ? -1 : res;
    }

    private int getMinCoins(int idx, int[] coins, int amount, int dp[][]){
        if(idx==0){
            if(amount%coins[0]==0) return amount/coins[0];
            return 100000;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake = getMinCoins(idx-1, coins, amount, dp);
        int take = 100000;
        if(coins[idx]<=amount){
            take = 1 + getMinCoins(idx, coins, amount-coins[idx], dp);
        }
        return dp[idx][amount] = Math.min(take, notTake);
    }
}
