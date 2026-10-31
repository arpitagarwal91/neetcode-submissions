class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for(int i=0;i<nums.length;i++){
            int c = Math.max(nums[i]+a, b);
            a = b;
            b = c;
        }
        return Math.max(a, b);
    }
}
