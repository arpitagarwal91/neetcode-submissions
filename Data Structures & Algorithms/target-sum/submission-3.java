class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0,0,nums,target);
    }

    public int dfs(int i, int curSum, int[] nums, int target){
        if(i==nums.length) {
            return curSum==target ? 1 : 0; //Forgot that curSum==target should only be checked once complete array is iterated.
        }
        return (dfs(i+1, curSum+nums[i], nums, target) + dfs(i+1, curSum-nums[i], nums, target));
    }
}
