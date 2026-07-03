class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            int sum = carry+digits[i];
            digits[i] = sum%10;
            carry = sum/10;
        }
        if(carry>0){
            int res[] = new int[digits.length+1];
            int p = 0;
            res[p++] = carry;
            for(int digit:digits) res[p++] = digit;
            return res;
        }
        return digits;
    }
}
