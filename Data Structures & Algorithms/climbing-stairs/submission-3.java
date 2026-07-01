class Solution {
    public int climbStairs(int n) {
       int a = 0;
       int b = 1;
       int c = a+b;
       for(int i=0;i<n;i++){
        a = b;
        b = c;
        c = a+b;
       } 
       return b;
    }
}
