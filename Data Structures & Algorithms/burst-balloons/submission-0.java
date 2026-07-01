class Solution {
    public int maxCoins(int[] nums) {
        Map<String, Integer> dp = new HashMap();
        int arr[] = new int[nums.length+2];
        arr[0] = 1;
        arr[nums.length+1] = 1;
        for(int i=0;i<nums.length;i++){
            arr[i+1] = nums[i];
        }
        return dfs(1,arr.length-2,arr,dp);
    }

    public int dfs(int l, int r, int nums[], Map<String, Integer> dp){
        String key = l+"-"+r;
        if(l>r) return 0;
        if(dp.containsKey(key)) return dp.get(key);
        dp.put(key, 0);
        for(int i=l;i<r+1;i++){
            int coins = nums[l-1]*nums[i]*nums[r+1];
            coins += dfs(l, i-1, nums, dp) + dfs(i+1, r, nums, dp);
            dp.put(key, Math.max(dp.get(key), coins)); 
        }
        return dp.get(key);
    }
}
