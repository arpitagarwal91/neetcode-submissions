class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    res = Math.max(res, dp[i]);
                }
            }
            System.out.print(dp[i]+" ");
        }
        return res;
    }
}
