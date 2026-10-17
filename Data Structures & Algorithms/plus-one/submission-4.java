class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        if(carry==1) {
            int res[] = new int[digits.length+1];
            res[0] = carry;
            int p = 1;
            for(int d:digits) res[p++] = d;
            return res;
        }
        return digits;
    }
}
