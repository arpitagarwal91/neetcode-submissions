class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0, r = 0;
        int maxIdx = 0;
        while(r<nums.length){
            if(maxIdx>=nums.length-1) return jumps;
            jumps++;
            for(int i=l;i<=r;i++){
                maxIdx = Math.max(maxIdx, nums[i]+i);
            }
            l = r+1;
            r = maxIdx;
        }
        return jumps;
    }
}
