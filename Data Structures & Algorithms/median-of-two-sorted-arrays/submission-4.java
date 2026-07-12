class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int A[] = nums1;
        int B[] = nums2;
        int total = nums1.length + nums2.length;
        int half = (total+1)/2;
        if(A.length>B.length){
            int tmp[] = B;
            B = A;
            A = tmp;
        }
        //O(log(min(A.length, B.length)))
        int l = 0, r = A.length;
        while(l<=r){
            int i = (l+r)/2;
            int j = half - i; 

            int aLeft = i>0 ? A[i-1] : Integer.MIN_VALUE;
            int aRight = (i)<A.length ? A[i] : Integer.MAX_VALUE;
            int bLeft = j>0 ? B[j-1] : Integer.MIN_VALUE;
            int bRight = j<B.length ? B[j] : Integer.MAX_VALUE;

            if(aLeft<=bRight && bLeft<=aRight){
                if(total%2==1){
                    return Math.max(aLeft, bLeft);
                }
                return ((Math.max(aLeft, bLeft)+Math.min(aRight, bRight))/2.0);
            }
            if(aLeft>bRight){
                r = i-1;
            }
            else l = i+1;
        }
        return -1;
    }
}
