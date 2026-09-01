class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(target>sum || (sum-target)%2==1) return 0; //Forgot this #3 base case
        int t = (sum-target)/2;
        int dp[][] = new int[nums.length][t+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i], -1);
        return getPartitionSum(nums.length-1, nums, t, dp);
    }

    private int getPartitionSum(int i, int nums[], int target, int[][] dp){
        if(i==0){
            if(target==0 && nums[0]==0) return 2; // Forgot this base case #1
            return (target==0 || target==nums[0]) ? 1 : 0; // Forgot this base case #2 
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notTake = getPartitionSum(i-1, nums, target, dp);
        int take = 0;
        if(nums[i]<=target) take = getPartitionSum(i-1, nums, target-nums[i], dp);
        dp[i][target] = take+notTake;
        return take+notTake;
    }
}
