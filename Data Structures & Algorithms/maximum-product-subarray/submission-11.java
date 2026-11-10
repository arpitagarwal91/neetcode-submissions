class Solution {
    public int maxProduct(int[] nums) {
        int minProd = 1;
        int maxProd = 1;
        int res = Integer.MIN_VALUE;
        for(int num:nums){
            int tmp = minProd;
            minProd = Math.min(num, Math.min(num*minProd, num*maxProd));
            maxProd = Math.max(num, Math.max(num*tmp, num*maxProd));
            res = Math.max(res, maxProd);
        }
        return res;
    }
}
