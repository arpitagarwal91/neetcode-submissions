class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int A[] = nums1.length<nums2.length ? nums1 : nums2;
       int B[] = nums1.length>=nums2.length ? nums1 : nums2;
       int total = A.length + B.length;
       int half = (total+1)/2;
       int l = 0, r = A.length;
       while(l<=r){
        int i = (l+r)/2;
        int j = half-i;
        int aLeft = i-1>=0 ? A[i-1] : Integer.MIN_VALUE;
        int bLeft = j-1>=0 ? B[j-1] : Integer.MIN_VALUE;
        int aRight = i<A.length ? A[i] : Integer.MAX_VALUE;
        int bRight = j<B.length ? B[j] : Integer.MAX_VALUE;
        if(aLeft<=bRight && bLeft<=aRight){
            if((A.length+B.length)%2==1) return Math.max(aLeft, bLeft);
            return ((Math.max(aLeft, bLeft)+Math.min(aRight, bRight))/2.0);
        }
        if(bLeft>aRight) l = i+1;
        else r = i-1;
       }
       return -1;
    }
}
