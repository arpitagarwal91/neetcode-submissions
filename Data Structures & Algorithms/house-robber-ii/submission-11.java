class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(getMaxRob(Arrays.copyOfRange(nums, 0, nums.length-1)),
        getMaxRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int getMaxRob(int nums[]){
        int prev2 = 0;
        int prev = nums.length>0 ? nums[0] : 0;
        for(int i=1;i<nums.length;i++){
            int notTake = prev;
            int take = nums[i];
            if(i>1) take+= prev2;
            int curi = Math.max(take, notTake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
