public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        Array.Sort(piles);
        int l = 1;
        int r = piles[piles.Length-1];
        while(l<r){
            int mid = (l+r)/2;
            if(viable(mid, h, piles)) r = mid;
            else l=mid+1;
        }
        return r;
    }

    public bool viable(int k, int h, int[] piles){
        int sum = 0;
        for(int i=0;i<piles.Length;i++){
            int val = piles[i]/k;
            if(piles[i]%k==0) sum+=val;
            else sum+=(val+1);
        }
        if(sum<=h) return true;
        return false;
    }
}
