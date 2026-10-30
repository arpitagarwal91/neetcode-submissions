class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total%2==1) return false;
        Boolean dp[][] = new Boolean[nums.length+1][(total/2)+1];
        return canPartition(0, nums, total/2, dp);
    }

    private boolean canPartition(int idx, int nums[], int target, Boolean dp[][]){
        if(target==0) return true;
        if(idx==nums.length) return false;
        if(dp[idx][target]!=null) return dp[idx][target];
        //not take
        boolean notTake = canPartition(idx+1, nums, target, dp);
        boolean take = false;
        if(nums[idx]<=target) take = canPartition(idx+1, nums, target-nums[idx], dp);
        return dp[idx][target] = (take || notTake);
    }
}
