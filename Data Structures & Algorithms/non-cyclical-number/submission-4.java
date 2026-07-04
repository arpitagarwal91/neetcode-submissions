class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while(!visit.contains(n)){
            visit.add(n);
            n = sumOfSquaresOfDigit(n);
            if(n==1) return true;
        }
        return false;
    }

    public int sumOfSquaresOfDigit(int num){
        int sum = 0;
        while(num>0){
            int d = num%10;
            sum+=(d*d);
            num/=10;
        }
        return sum;
    }
}
