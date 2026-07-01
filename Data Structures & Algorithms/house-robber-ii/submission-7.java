class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(maxAmount(nums, 0, nums.length-2), maxAmount(nums, 1, nums.length-1));
    }

    public int maxAmount(int[] nums, int start, int end){
        int rob1 = 0;
        int rob2 = 0;
        for(int i=start;i<=end;i++){
            int c = Math.max(rob1+nums[i], rob2);
            rob1 = rob2;
            rob2 = c;
        }
        return Math.max(rob1, rob2);
    }
}
