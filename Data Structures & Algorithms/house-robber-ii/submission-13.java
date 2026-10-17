class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int arr1[] = Arrays.copyOfRange(nums, 0, nums.length-1);
        int arr2[] = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob1(arr1), rob1(arr2));
    }

    private int rob1(int[] nums){
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return getMaxRobAmount(0, nums, dp);
    }

    private int getMaxRobAmount(int idx, int nums[], int[] dp){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int notTake = getMaxRobAmount(idx+1, nums, dp);
        int take = nums[idx] + getMaxRobAmount(idx+2, nums, dp);
        return dp[idx] = Math.max(take, notTake);
    }
}
