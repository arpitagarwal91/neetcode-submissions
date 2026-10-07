class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return getMaxRob(nums.length-1, nums, dp);
    }

    private int getMaxRob(int idx, int[] nums, int[] dp){
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int steal = nums[idx] + getMaxRob(idx-2, nums, dp);
        int notSteal = getMaxRob(idx-1, nums, dp);
        return dp[idx] = Math.max(steal, notSteal);
    }
}
