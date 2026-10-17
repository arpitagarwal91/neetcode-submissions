class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        int offset = 1;
        for(int i=1;i<n+1;i++){
            if(2*offset==i){
                offset = i;
            }
            res[i] = 1 + res[i-offset];
        }
        return res;
    }
}
