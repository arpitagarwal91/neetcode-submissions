class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while(n!=1){
            int k = sumOfSquaresOfDigits(n);
            if(visit.contains(k)) return false;
            visit.add(k);
            n = k;
        }
        return n==1;
    }

    private int sumOfSquaresOfDigits(int n){
        int sum = 0;
        while(n!=0){
            int d = n%10;
            sum += (d*d);
            n/=10;
        }
        return sum;
    }
}
