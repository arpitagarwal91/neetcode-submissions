class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0;
        int maxIdx = -1;
        int jumps = 0;
        while(r<nums.length-1){
            jumps++;
            for(int i=l;i<=r;i++){
                maxIdx = Math.max(maxIdx, i + nums[i]);
            }
            l = r+1;
            r = maxIdx;
        }
        return jumps;
    }
}
