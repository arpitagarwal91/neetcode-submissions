class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        Boolean dp[][] = new Boolean[nums.length][(sum/2)+1];
        return hasTargetSum(0, nums, 0, sum/2, dp);
    }

    private boolean hasTargetSum(int idx, int[] nums, int curSum, int target, Boolean dp[][]){
        if(curSum>target) return false;
        if(curSum==target) return true;
        if(idx==nums.length) return false;
        if(dp[idx][curSum]!=null) return dp[idx][curSum];

        boolean take = hasTargetSum(idx+1, nums, curSum+nums[idx], target, dp);
        if(take) {
            return dp[idx][curSum] = true;
        }

        boolean notTake = hasTargetSum(idx+1, nums, curSum, target, dp);
        return dp[idx][curSum] = notTake;
    }
}
