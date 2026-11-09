class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().orElse(Integer.MAX_VALUE);
        while(l<=r){
            int mid = (l+r)/2;
            if(isFeasible(piles, mid, h)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean isFeasible(int[] piles, int k, int h){
        double total = 0;
        for(int p:piles){
            double d = (p/k);
            if(p%k!=0) d++;
            total += d;
        }
        return total<=h;
    }
}
