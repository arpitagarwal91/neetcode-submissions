class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while(n!=1){
            if(visit.contains(n)) return false;
            visit.add(n);
            n = sumSquareDigits(n);
        }
        return n==1;
    }

    private int sumSquareDigits(int n){
        int sum = 0;
        while(n!=0){
            int d = n%10;
            sum += (d*d);
            n = n/10;
        }
        return sum;
    }
}
