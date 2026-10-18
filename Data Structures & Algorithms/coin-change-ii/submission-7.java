class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return findAllWays(0, amount, coins, dp);
    }

    private int findAllWays(int idx, int amount, int[] coins, int[][] dp){
        if(idx==coins.length){
            if(amount==0) return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notPick = findAllWays(idx+1, amount, coins, dp);
        int pick = 0;
        if(coins[idx]<=amount){
            pick = findAllWays(idx, amount-coins[idx], coins, dp);
        }
        return dp[idx][amount] = pick+notPick;
    }
}
