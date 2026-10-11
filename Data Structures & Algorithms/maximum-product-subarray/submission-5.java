class Solution {
    public int maxProduct(int[] nums) {
        int minProd = 1, maxProd = 1;
        int res = Integer.MIN_VALUE;
        for(int num:nums){
            int tmp = maxProd;
            maxProd = Math.max(Math.max(num*tmp, num*minProd), num);
            minProd = Math.min(Math.min(num*tmp, num*minProd), num);
            res = Math.max(res, maxProd);
        }
        return res;
    }
}
