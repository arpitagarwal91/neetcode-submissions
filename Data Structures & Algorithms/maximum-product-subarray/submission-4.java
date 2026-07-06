class Solution {
    public int maxProduct(int[] nums) {
        int minProd = 1, maxProd = 1, res = Integer.MIN_VALUE;
        for(int num:nums) res = Math.max(res, num);

        for(int n:nums){
            int tmp = maxProd;
            maxProd = Math.max(Math.max(n*minProd, n*tmp), n);
            minProd = Math.min(Math.min(n*minProd, n*tmp), n);
            res = Math.max(res, maxProd);
        }
        return res;
    }
}
