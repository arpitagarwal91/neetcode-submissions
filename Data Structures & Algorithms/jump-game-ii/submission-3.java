class Solution {
    public int jump(int[] nums) {
        // int dp[][] = new int[nums.length][nums.length];
        // for(int i=0;i<nums.length;i++) Arrays.fill(dp[i], -1);
        // return getMinJumps(0,0,nums,dp);
        int l = 0, r = 0, jumps = 0;
        while(r<nums.length-1){
            int farthest = 0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            jumps++;
            l = r+1;
            r = farthest;
        }
        return jumps;
    }

    private int getMinJumps(int idx, int jumps, int[] nums, int dp[][]){
        if(idx>=nums.length-1) return jumps;
        if(dp[idx][jumps]!=-1) return dp[idx][jumps];
        int mini = Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx];i++){
            mini = Math.min(mini, getMinJumps(idx+i, jumps+1, nums, dp));
        }
        return dp[idx][jumps] = mini;
    }
}
