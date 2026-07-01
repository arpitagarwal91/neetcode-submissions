class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int r1 = 0, r2 = 0;
        for(int i=0;i<nums.length-1;i++){
            int tmp = Math.max(r1+nums[i],r2);
            r1 = r2;
            r2 = tmp;
        }
        int p1 = 0, p2 = 0;
        for(int i=1;i<nums.length;i++){
            int tmp = Math.max(p1+nums[i],p2);
            p1 = p2;
            p2 = tmp;
        }
        return Math.max(r2,p2);
    }
}
