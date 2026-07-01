class Solution {
    public int[] plusOne(int[] digits) {
       int carry = 1;
       List<Integer> res = new ArrayList<Integer>();
       for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i]+carry;
            res.add(sum%10);
            carry = sum/10;
       }
       if(carry>0) res.add(carry);
       int ans[] = new int[res.size()];
       for(int i=0;i<res.size();i++){
        ans[i] = res.get(res.size()-1-i);
       }
       return ans;
    }
}
