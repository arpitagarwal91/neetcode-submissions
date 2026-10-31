class Solution {
    public int findDuplicate(int[] nums) {
        for(int num:nums){
            if(nums[Math.abs(num)-1]>0){
                nums[Math.abs(num)-1]*=-1;
            }
            else return Math.abs(num);
        }
        return -1;
    }
}
