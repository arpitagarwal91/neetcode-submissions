class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = (n>>i) & 1;
            res+=bit;
        }
        return res;
    }
}
