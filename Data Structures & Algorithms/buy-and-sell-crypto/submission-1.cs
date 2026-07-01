public class Solution {
    public int MaxProfit(int[] prices) {
        int l=0;
        int r=l;
        int res = 0;
        while(r<prices.Length){
            res = Math.Max(res, prices[r]-prices[l]);
            if(prices[l]>=prices[r]) l=r;
            r++;
        }
        return res;
    }
}
