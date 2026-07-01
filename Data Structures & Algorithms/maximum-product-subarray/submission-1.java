class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int num:nums) res = Math.max(res, num);
        int curMin = 1, curMax = 1;
        for(int num:nums){
            if(num==0){
                curMin = 1;
                curMax = 1;
            }
            int tmp = curMax*num;
            curMax = Math.max(num, Math.max(curMax*num, curMin*num));
            curMin = Math.min(num, Math.min(tmp, curMin*num));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
