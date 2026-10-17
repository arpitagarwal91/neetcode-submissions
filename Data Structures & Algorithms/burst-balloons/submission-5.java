class Solution {
    public int maxCoins(int[] nums) {
        int arr[] = new int[nums.length+2];
        int p = 1;
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for(int num:nums) arr[p++] = num;
        int dp[][] = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        return getMaxCoins(1, arr.length-2, arr, dp);
    }

    private int getMaxCoins(int l, int r, int nums[], int[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int res =  0;
        for(int i=l;i<=r;i++){
            int count = nums[l-1]*nums[i]*nums[r+1];
            int left = getMaxCoins(l, i-1, nums, dp);
            int right = getMaxCoins(i+1, r, nums, dp);
            res = Math.max(res, left+count+right);
        }
        return dp[l][r] = res;
    }
}
