class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        int res = 1001;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[r]){
                res = Math.min(res, nums[mid]);
                r = mid-1;
            }
            else{
                res = Math.min(res, nums[mid]);
                l = mid+1;
            }
        }
        return res;
    }
}
