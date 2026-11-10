class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if(target>sum) return 0;
        if((sum-target)%2==1) return 0;
        Integer dp[][] = new Integer[nums.length][((sum-target)/2)+1];
        return findAllWays(0, nums, (sum-target)/2, dp);
    }

    private int findAllWays(int idx, int[] nums, int target, Integer dp[][]){
        if(idx==nums.length){
            if(target==0) return 1;
            return 0;
        }
        if(dp[idx][target]!=null) return dp[idx][target];

        int notTake = findAllWays(idx+1, nums, target, dp);

        int take = 0;
        if(nums[idx]<=target){
            take = findAllWays(idx+1, nums, target-nums[idx], dp);
        }

        return dp[idx][target] = take+notTake;
    }
}
