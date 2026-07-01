public class Solution {
    public int Search(int[] nums, int target) {
       int l=0;
       int r=nums.Length;
       while(l<=r){
            int mid = l+(r-l)/2;
            if(mid<0 || mid>=nums.Length) break;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) l = mid+1;
            if(nums[mid]>target) r = mid-1;
       }
       return -1;
    }
}
