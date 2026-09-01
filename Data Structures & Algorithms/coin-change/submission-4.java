class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) Arrays.fill(dp[i], -1);
        int ans = getCoins(coins.length-1, amount, coins, dp);
        return ans==1000000 ? -1 : ans;
    }

    private int getCoins(int i, int sum, int coins[], int[][] dp){
        if(i==0){
            if(sum%coins[i]==0) return sum/coins[i];
            return 1000000;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int notPick = getCoins(i-1, sum, coins, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[i]<=sum) pick = 1 + getCoins(i, sum-coins[i], coins, dp);
        return Math.min(pick, notPick);
    }
}
