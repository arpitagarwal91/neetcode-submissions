class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2==1) return false;
        return dfs(0, 0, sum, nums);
    }

    public boolean dfs(int i, int curSum, int sum, int[] nums){
        if(i==nums.length && curSum==(sum/2)) return true;
        if(i==nums.length || curSum>(sum/2)) return false;
        return dfs(i+1, curSum+nums[i], sum, nums) || dfs(i+1, curSum, sum, nums);
    }
}
