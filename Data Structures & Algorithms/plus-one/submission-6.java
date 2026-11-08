class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i]+carry;
            carry = sum/10;
            digits[i] = sum%10;
        }
        if(carry==0) return digits;
        List<Integer> res = new ArrayList<>();
        res.add(carry);
        res.addAll(Arrays.stream(digits).boxed().collect(Collectors.toList()));
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
