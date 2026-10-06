class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int res = Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<=nums[r]){
                res = Math.min(res, nums[mid]);
                r = mid-1;
            }
            else{
                res = Math.min(res, nums[l]);
                l = mid+1;                
            }
        }
        return res;
    }
}
