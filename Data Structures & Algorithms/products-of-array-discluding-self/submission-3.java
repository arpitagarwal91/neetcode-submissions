class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod[] = new int[nums.length];
        int left = 1;
        for(int i=0;i<nums.length;i++){
            prod[i] = left;
            left*=nums[i];
        }
        int right = 1;
        for(int i=nums.length-1;i>=0;i--){
            prod[i]*=right;
            right*=nums[i];
        }
        return prod;
    }
}  
