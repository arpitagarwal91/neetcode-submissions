class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            res<<=1;
            int bit = (n & 1);
            res|=bit;
            n = n>>1;
        }
        return res;
    }
}
