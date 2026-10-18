class Solution {
    public double myPow(double x, int n) {
        long power = Math.abs((long) n);
        double res = 1;
        while(power!=0){
            if(power%2==1){
                res*=x;
            }
            x*=x;
            power = power>>1;
        }
        return n<0 ? (1/res) : res;
    }
}
