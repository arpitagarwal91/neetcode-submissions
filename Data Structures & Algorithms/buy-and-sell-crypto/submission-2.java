class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r= 0;
        int res = 0;
        while(r<prices.length){
            if(prices[l]<prices[r]){
                res = Math.max(res, prices[r]-prices[l]);
            }
            else{
                l = r;
            }
            r++;
        }
        return res;
    }
}
