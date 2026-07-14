class Solution {
    public int maxCoins(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        int nums1[] = new int[nums.length+2];
        nums1[0] = 1;
        nums1[nums.length+1] = 1;
        int p = 0;
        for(int i=1;i<nums.length+1;i++) nums1[i] = nums[p++];
        return dfs(nums1, dp, 1, nums1.length-2);
    }

    public int dfs(int nums[], Map<String, Integer> dp, int l, int r){
        if(l>r) return 0;
        if(dp.containsKey(l+"-"+r)) return dp.get(l+"-"+r);

        dp.put(l+"-"+r, 0);
        for(int i=l;i<=r;i++){
            int balloons = nums[l-1]*nums[i]*nums[r+1];
            balloons += dfs(nums, dp, l, i-1) + dfs(nums, dp, i+1, r);
            dp.put(l+"-"+r, Math.max(dp.get(l+"-"+r), balloons));
        }
        return dp.get(l+"-"+r);
    }
}
