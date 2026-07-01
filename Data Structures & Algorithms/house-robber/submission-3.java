class Solution {
    public int rob(int[] nums) {
        int r1 = 0;
        int r2 = 0;
        for(int num:nums){
            int tmp = r1;
            r1 = r2;
            r2 = Math.max(tmp+num,r2);
        }
        return Math.max(r1,r2);
    }
}
