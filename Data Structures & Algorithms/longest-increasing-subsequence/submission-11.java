class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int lb = getLb(lis, nums[i]);
            if(lb==lis.size()){
                lis.add(nums[i]);
            }
            else{
                lis.set(lb, nums[i]);
            }
        }
        return lis.size();
    }

    private int getLb(List<Integer> ls, int target){
        int l = 0, r = ls.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(ls.get(mid)>=target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
