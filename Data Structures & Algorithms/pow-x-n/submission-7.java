class Solution {
    public double myPow(double x, int n) {
        if(x==0 || x==1) return x;
        long power = Math.abs((long)n);
        double res = 1;
        while(power>0){
            if(power%2==1){
                res*=x;
            }
            x*=x;
            power = power>>1;
        }
        return n>0 ? res : (1/res);
    }
}
