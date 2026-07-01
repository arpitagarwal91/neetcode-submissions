class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<dp.length-1;i++){
            dp[i] = Math.min(cost[i]+dp[i-1], cost[i]+dp[i-2]);
        }
        return Math.min(dp[dp.length-2], dp[dp.length-3]);
    }
}
