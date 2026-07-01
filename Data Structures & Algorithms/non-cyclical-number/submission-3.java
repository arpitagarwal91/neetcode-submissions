class Solution {
    public boolean isHappy(int n) {
       Set<Integer> visit = new HashSet();
       while(n!=1){
         int k = sumOfSquareOfDigits(n);
         if(visit.contains(k)) return false;
         visit.add(k);
         n = k;
       }
       return true;
    }

    public int sumOfSquareOfDigits(int n){
        int res = 0;
        while(n!=0){
            int d = n%10;
            res+=(d*d);
            n=n/10;
        }
        return res;
    }
}
