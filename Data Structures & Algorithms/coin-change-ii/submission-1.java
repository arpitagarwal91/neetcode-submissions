class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        dp[0] = 1;

        for(int i=coins.length-1;i>=0;i--){
            int nextDp[] = new int[amount+1];
            nextDp[0] = 1;
            for(int a=1;a<amount+1;a++){
                nextDp[a] = dp[a];
                if(a-coins[i]>=0){
                    nextDp[a]+=nextDp[a-coins[i]];
                }
            }
            dp = nextDp;
        }

        return dp[amount];
    }
}
