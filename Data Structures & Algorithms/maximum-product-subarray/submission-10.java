class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1, minProd = 1;
        int res = Integer.MIN_VALUE;
        for(int num:nums){
            int tmp = maxProd;
            maxProd = Math.max(Math.max(minProd*num, maxProd*num), num);
            minProd = Math.min(Math.min(minProd*num, tmp*num), num);
            res = Math.max(res, maxProd);
        }
        return res;
    }
}
