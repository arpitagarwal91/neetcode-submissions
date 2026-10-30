class Solution {
    public int change(int amount, int[] coins) {
        Integer dp[][] = new Integer[coins.length][amount+1];
        return getAllWays(0, coins, amount, dp);
    }

    private int getAllWays(int idx, int[] coins, int target, Integer dp[][]){
        if(idx==coins.length){
            if(target==0) return 1;
            return 0;
        }
        if(dp[idx][target]!=null) return dp[idx][target];
        //not take
        int notTake = getAllWays(idx+1, coins, target, dp);

        //take
        int take = 0;
        if(coins[idx]<=target){
            take += getAllWays(idx, coins, target-coins[idx], dp);
        }
        return dp[idx][target] = notTake+take;
    }
}
