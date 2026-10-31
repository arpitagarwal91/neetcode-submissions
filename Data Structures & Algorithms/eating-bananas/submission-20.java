class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Arrays.stream(piles).max().orElse(Integer.MAX_VALUE);
        int l = 1;
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

    private boolean isFeasible(int[] piles, int k, int h){
        double total = 0;
        for(int pile:piles){
            total += (pile/k);
            if(pile%k>0) total++;
        }
        return total<=h;
    }
}
