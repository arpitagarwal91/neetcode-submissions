class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(rob1(Arrays.copyOfRange(nums, 0, nums.length-1)), rob1(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int rob1(int[] nums){
        int a = 0, b = 0;
        for(int num:nums){
            int c = Math.max(num + a, b);
            a = b;
            b = c;
        }
        return Math.max(a, b);
    }
}
