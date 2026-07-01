public class Solution {
    public int Rob(int[] nums) {
        int a = 0, b = nums[0];
        for(int i=1;i<nums.Length;i++){
            int rob = Math.Max(a+nums[i], b);
            a = b;
            b = rob;
        }
        return b;
    }
}
