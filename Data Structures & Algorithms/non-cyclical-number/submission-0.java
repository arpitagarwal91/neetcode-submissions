class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet();
        n = findSumOfSquareOfDigits(n);
        while(!visit.contains(n) && n != 1){
            visit.add(n);
            n = findSumOfSquareOfDigits(n);
        }
        return n == 1?true:false;
    }

    public int findSumOfSquareOfDigits(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum+=(digit*digit);
            n = n/10;
        }
        return sum;
    }
}
