class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i=0;i<32;i++){
            int bit = n&1;
            count += bit;
            n = n>>1;
        }
        return count;
    }
}
