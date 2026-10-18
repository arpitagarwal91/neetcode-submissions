class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1_000_000_000;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(isFeasible(piles, mid, h)){
                res = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return res;
    }

    private boolean isFeasible(int[] piles, int b, int h){
        double res = 0;
        for(int pile:piles){
            res += Math.ceil((double)pile/(double)b);
        }
        return res<=h;
    }
}
