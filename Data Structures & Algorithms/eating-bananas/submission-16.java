class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000_000_000;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(isFeasible(mid, piles, h)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }

    private boolean isFeasible(int k, int[] piles, int h){
        double total = 0;
        for(int i=0;i<piles.length;i++){
            double time = Math.ceil((double)piles[i]/(double)k);
            total+=time;
        }
        return total<=h;
    }
}
