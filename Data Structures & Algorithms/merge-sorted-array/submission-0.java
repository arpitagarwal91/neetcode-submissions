class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = 0, i2 = 0;
        while(i1<m && i2<n){
            if(nums1[m-1-i1]>nums2[n-1-i2]){
                nums1[m+n-1-i1-i2] = nums1[m-1-i1];
                i1++;
            }
            else{
                nums1[m+n-1-i1-i2] = nums2[n-1-i2];
                i2++;
            }
        }
        while(i1<m){
            nums1[m+n-1-i1-i2] = nums1[m-1-i1];
            i1++;
        }
        while(i2<n){
            nums1[m+n-1-i1-i2] = nums2[n-1-i2];
            i2++;
        }
    }
}