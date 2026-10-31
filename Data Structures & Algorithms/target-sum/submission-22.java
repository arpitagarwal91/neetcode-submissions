class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum(); // A+B = sum; A-B = target
        if((sum-target)%2==1 ||target>sum) return 0;
        Integer dp[][] = new Integer[nums.length][((sum-target)/2)+1];
        return getAllWays(0, nums, (sum-target)/2, dp);
    }

    private int getAllWays(int idx, int[] nums, int target, Integer[][] dp){
        if(idx==nums.length) {
            if(target==0) return 1;
            return 0;
        }
        if(dp[idx][target]!=null) return dp[idx][target];
        //notTake
        int notTake = getAllWays(idx+1, nums, target, dp);

        //take
        int take = 0;
        if(nums[idx]<=target){
            take += getAllWays(idx+1, nums, target-nums[idx], dp);
        }
        return dp[idx][target] = notTake+take;
    }
}
