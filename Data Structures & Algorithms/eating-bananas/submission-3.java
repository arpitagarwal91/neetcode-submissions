class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length-1];
        while(start<end){
            int mid = (start + end)/2;
            if(isViable(mid, piles, h)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return end;
    }

    public boolean isViable(int k, int[] piles, int h){
        int total = 0;
        for(int i=0;i<piles.length;i++){
            total += Math.ceil((double) piles[i] / k);
        }
        if(total<=h) return true;
        return false;
    }
}
