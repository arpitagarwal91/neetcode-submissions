class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[r]){
                if(nums[mid]<=target && target<=nums[r]){
                    res = mid;
                    l = mid+1;
                }
                else r = mid-1;
            }
            else{
                if(nums[l]<=target && target<=nums[mid]){
                    res = mid;
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return res==-1 || nums[res]!=target ? -1 : res;
    }
}
