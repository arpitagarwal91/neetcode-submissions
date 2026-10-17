class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if((sum-target)%2==1 || target>sum) return 0;
        int dp[][] = new int[nums.length][((sum-target)/2)+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i], -1);
        return findAllWays(0, nums, (sum-target)/2, dp);
    }

    private int findAllWays(int idx, int nums[], int target, int[][] dp){
        if(idx==nums.length){
            if(target==0) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notPick = findAllWays(idx+1, nums, target, dp);
        int pick = 0;
        if(nums[idx]<=target) pick = findAllWays(idx+1, nums, target-nums[idx], dp);
        return dp[idx][target] = pick+notPick;
    }
}
