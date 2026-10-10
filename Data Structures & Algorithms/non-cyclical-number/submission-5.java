class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while(n!=1){
            n = sumOfDigitSquare(n);
            if(visit.contains(n)) return false;
            visit.add(n);
        }
        return true;
    }

    private int sumOfDigitSquare(int k){
        int sum = 0;
        while(k>0){
            int d = (k%10);
            sum+=(d*d);
            k/=10;
        }
        return sum;
    }
}
