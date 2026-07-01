public class Solution {
    public int[] PlusOne(int[] digits) {
        int []res = new int[digits.Length+1];
        int []res0 = new int[digits.Length];
        int carry = 1;
        for(int i=digits.Length-1;i>=0;i--){
            res[i+1] = digits[i] + carry;
            carry = res[i+1]/10;
            res[i+1]%=10;
        }
        if(carry==1) res[0]=1;
        if(res[0]==0) {
            Array.Copy(res, 1, res0, 0, digits.Length);
            return res0;
        }
        return res;
    }
}
