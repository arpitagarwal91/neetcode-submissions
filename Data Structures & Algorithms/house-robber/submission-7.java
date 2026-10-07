class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return getMaxRob(nums.length-1, nums, dp);
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            int notSteal = dp[i-1];
            int steal = nums[i];
            if(i>1) steal+= dp[i-2];
            dp[i] = Math.max(steal, notSteal);
        }
        return dp[nums.length-1];
    }

    private int getMaxRob(int idx, int[] nums, int[] dp){
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int steal = nums[idx] + getMaxRob(idx-2, nums, dp);
        int notSteal = getMaxRob(idx-1, nums, dp);
        return dp[idx] = Math.max(steal, notSteal);
    }
}
