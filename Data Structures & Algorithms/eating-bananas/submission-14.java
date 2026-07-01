class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length-1];
        int res = r;
        while(l<=r){
            int k = (l+r)/2;
            int time = 0;
            for(int pile:piles){
                time+=Math.ceil(Math.ceil((double)pile/k));
            }
            if(time<=h){
                res = Math.min(res, k);
                r = k-1;
            }
            else{
                l = k+1;
            }
        }
        return res;
    }
}