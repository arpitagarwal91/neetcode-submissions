class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int carry = (a&b)<<1;
            int xor = a^b;
            a = xor;
            b = carry;
        }
        return a;
    }
}
