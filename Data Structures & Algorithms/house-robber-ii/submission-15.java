class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(robAll(Arrays.copyOfRange(nums, 0, nums.length-1)), robAll(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int robAll(int nums[]){
        int a = 0, b = 0;
        for(int num:nums){
            int c = Math.max(a+num, b);
            a = b;
            b = c;
        }
        return Math.max(a, b);
    }
}
