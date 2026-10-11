class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) Arrays.fill(dp[i], -1);
        return findAllWays(coins.length-1, coins, amount, dp);
    }

    private int findAllWays(int idx, int[] coins, int amount, int[][] dp){
        if(idx==0){
            if(amount==0) return 1;
            if(amount%coins[0]==0) return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notTake = findAllWays(idx-1, coins, amount, dp);
        int take = 0;
        if(coins[idx]<=amount){
            take = findAllWays(idx, coins, amount-coins[idx], dp);
        }
        return dp[idx][amount] = take+notTake;
    }
}
