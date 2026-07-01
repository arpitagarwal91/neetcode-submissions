public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int []A = nums1;
        int []B = nums2;
        if(B.Length<A.Length){
            int []tmp = B;
            B = A;
            A = tmp;
        }
        int total = A.Length+B.Length;
        int half = (total+1)/2;
        int l = 0;
        int r = A.Length;
        while(l<=r){
            int i = (l+r)/2;
            int j = half - i;
            
            int Aleft = i<=0 ? int.MinValue : A[i-1];
            int Aright = i>=A.Length ? int.MaxValue : A[i];
            int Bleft = j<=0 ? int.MinValue : B[j-1];
            int Bright = j>=B.Length ? int.MaxValue : B[j];

            if(Aleft<=Bright && Bleft<=Aright){
                if(total%2!=0) return Math.Max(Aleft, Bleft);
                return (Math.Max(Aleft, Bleft)+ Math.Min(Aright, Bright))/2.0;
            }
            else if(Aleft>Bright) r = i-1;
            else l = i+1;
        }
        return -1;
    }
}
