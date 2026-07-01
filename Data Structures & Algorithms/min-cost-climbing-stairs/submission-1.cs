public class Solution {
    public int MinCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.Length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.Length;i++){
            dp[i] = Math.Min(cost[i]+dp[i-1], cost[i]+dp[i-2]);
        }
        return Math.Min(dp[dp.Length-2],dp[dp.Length-3]);
    }
}
