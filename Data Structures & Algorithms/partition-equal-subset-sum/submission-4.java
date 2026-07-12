class Solution {

    Map<String, Boolean> dp = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2==1) return false;
        return dfs(0, 0, sum, nums);
    }

    public boolean dfs(int i, int curSum, int sum, int[] nums){
        if(dp.containsKey(i+"-"+curSum)) return dp.get(i+"-"+curSum);
        if(i==nums.length && curSum==(sum/2)) return true;
        if(i==nums.length || curSum>(sum/2)) return false;
        boolean res = dfs(i+1, curSum+nums[i], sum, nums) || dfs(i+1, curSum, sum, nums);
        dp.put(i+"-"+curSum, res);
        return dp.get(i+"-"+curSum);
    }
}
