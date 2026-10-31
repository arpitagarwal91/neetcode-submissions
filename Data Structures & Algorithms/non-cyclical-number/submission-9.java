class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while(n!=1){
            int k = sumOfDigitSquares(n);
            if(k==1) return true;
            if(visit.contains(k)) return false;
            visit.add(k);
            n = k;
        }
        return n==1;
    }

    private int sumOfDigitSquares(int n){
        int num = 0;
        while(n!=0){
            int d = n%10;
            num += (d*d);
            n = n/10;
        }
        return num;
    }
}
