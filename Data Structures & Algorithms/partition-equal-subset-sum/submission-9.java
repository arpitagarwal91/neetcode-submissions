class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1) return false;
        Boolean dp[][] = new Boolean[nums.length][(sum/2)+1];
        return isPartPossible(0, nums, sum/2, dp);
    }

    private boolean isPartPossible(int idx, int[] nums, int target, Boolean dp[][]){
        if(idx==nums.length){
            if(target==0) return true;
            return false;
        }
        if(dp[idx][target]!=null) return dp[idx][target];

        boolean notTake  = isPartPossible(idx+1, nums, target, dp);
        boolean take = false;
        if(nums[idx]<=target){
            take = isPartPossible(idx+1, nums, target-nums[idx], dp);
        }

        return dp[idx][target] = take || notTake;
    }
}
