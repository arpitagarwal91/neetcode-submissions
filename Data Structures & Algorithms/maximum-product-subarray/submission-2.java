class Solution {
    public int maxProduct(int[] nums) {
        int curMin = 1, curMax = 1;
        int res = Integer.MIN_VALUE;
        for(int num: nums) res = Math.max(res, num);

        for(int n: nums){
            int tmp = curMax;
            curMax = Math.max(Math.max(n*curMax,n*curMin),n);
            curMin = Math.min(Math.min(n*tmp,n*curMin),n);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
