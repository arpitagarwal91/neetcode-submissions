class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        Arrays.stream(nums).boxed().forEach(k -> ls.add(k));
        ls.add(1);
        nums = ls.stream().mapToInt(Integer::intValue).toArray();
        Integer dp[][] = new Integer[nums.length][nums.length];
        return getMaxCoins(1, nums.length-2, nums, dp);
    }

    private int getMaxCoins(int l, int r, int[] nums, Integer dp[][]){
        if(r<l) return 0;
        if(dp[l][r]!=null) return dp[l][r];

        int res = Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            int left = getMaxCoins(l, i-1, nums, dp);
            int right = getMaxCoins(i+1, r, nums, dp);

            int coins = nums[l-1]*nums[i]*nums[r+1];
            res = Math.max(res, coins+left+right);
        }
        return dp[l][r] = res;
    }
}
