class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum%2==1) return false;
        Boolean dp[][] = new Boolean[nums.length+1][(sum/2)+1];
        return isPartitionSumPossible(0, nums, sum/2, dp);
    }

    private boolean isPartitionSumPossible(int idx, int nums[], int target, Boolean dp[][]){
        if(target==0) return true;
        if(idx==nums.length) return false;
        if(dp[idx][target]!=null) return dp[idx][target];
        boolean notTake = isPartitionSumPossible(idx+1, nums, target, dp);
        boolean take = false;
        if(nums[idx]<=target){
            take = isPartitionSumPossible(idx+1, nums, target-nums[idx], dp);
        }
        return dp[idx][target] = (take || notTake);
    }
}
