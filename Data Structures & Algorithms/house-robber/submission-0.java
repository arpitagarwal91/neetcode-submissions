class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int num:nums){
            int c = Math.max(rob1+num, rob2);
            rob1 = rob2;
            rob2 = c;
        }
        return rob2;
    }
}
