class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for(int num:nums){
            int lb = getLowerBound(num, lis);
            if(lb==lis.size()){
                lis.add(num);
            }
            else{
                lis.set(lb, num);
            }
        }
        return lis.size();
    }

    private int getLowerBound(int num, List<Integer> ls){
        int l = 0, r = ls.size()-1;
        int res = ls.size();
        while(l<=r){
            int mid = (l+r)/2;
            if(ls.get(mid)>=num){
                res = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return res;
    }
}
