class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int p:piles) max = Math.max(max, p);
        int l = 1;
        int r = max;
        while(l<=r){
            int mid = (l+r)/2;
            if(isFeasible(mid, piles, h)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    public boolean isFeasible(int p, int[] piles, int h){
        int t = 0;
        for(int pile:piles){
            t += (pile/p);
            if(pile%p>0) t++;
        }
        System.out.println(t+"--"+p);
        return t<=h;
    }
}
