class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long power = Math.abs((long)n);
        while(power!=0){
            if(power%2==1) res*=x;
            x*=x;
            power>>=1;
        }
        return n<0 ? 1/res : res;
    }
}
