class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum  = 0;
        for(int num:nums) sum+=num;
        if(target>sum || (sum-target)%2==1) return 0;
        int dp[][] = new int[nums.length][((sum-target)/2)+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return findAllWays(nums.length-1, nums, (sum-target)/2, dp); //Understand why this.
    }

    private int findAllWays(int idx, int[] nums, int target, int[][] dp){
        if(idx==0){
            if(target==0 && nums[0]==0) return 2;
            if(target==0 || nums[0]==target) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notTake = findAllWays(idx-1, nums, target, dp);
        int take = 0;
        if(nums[idx]<=target){
            take = findAllWays(idx-1, nums, target-nums[idx], dp);
        }
        return dp[idx][target] = take+notTake;
    }
}
