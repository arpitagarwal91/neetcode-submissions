public class Solution {
    public int Rob(int[] nums) {
        int a = 0, b = nums[0];
        for(int i=1;i<nums.Length-1;i++){
            int rob = Math.Max(nums[i]+a, b);
            a = b;
            b = rob;
        }
        if(nums.Length==1) return b;
        int c = 0, d = nums[1];
        for(int i=2;i<nums.Length;i++){
            int rob = Math.Max(nums[i]+c, d);
            c = d;
            d = rob;
        }
        return Math.Max(b,d);
    }
}
