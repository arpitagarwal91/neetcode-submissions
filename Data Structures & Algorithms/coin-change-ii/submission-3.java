class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) Arrays.fill(dp[i], -1);
        return getCoins(coins.length-1, amount, coins, dp);
    }

    private int getCoins(int i, int sum, int[] coins, int[][] dp){
        if(i==0){
            if(sum%coins[i]==0) return 1;
            if(sum==0) return 1;
            return 0;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int notPick = getCoins(i-1, sum, coins, dp);
        int pick = 0;
        if(coins[i]<=sum) pick = getCoins(i, sum-coins[i], coins, dp);

        return dp[i][sum] = pick+notPick;
    }
}
