class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }

        for(int a=1;a<amount+1;a++){
            for(int i=coins.length-1;i>=0;i--){
                dp[i][a] = dp[i+1][a];
                if(a-coins[i]>=0){
                    dp[i][a]+=dp[i][a-coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}
