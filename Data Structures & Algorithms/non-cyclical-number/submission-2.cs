public class Solution {
    public bool IsHappy(int n) {
        var visit = new HashSet<int>();
        while(n>=1){
            int sum = 0;
            while(n!=0){
                int d = n%10;
                sum+=(d*d);
                n = n/10;
            }
            if(sum==1) return true;
            else {
                if(visit.Contains(sum)) return false;
                visit.Add(sum);
                n = sum;
            }
        }
        return false;
    }
}
