class Solution {
    public int findDuplicate(int[] nums) {
        // for(int num:nums){
        //     int idx = Math.abs(num)-1;
        //     if(nums[idx]<0){
        //         return Math.abs(num);
        //     }
        //     nums[idx]*=-1;
        // }
        // return 0;
        int slow = 0, fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        int slow2 = 0;
        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow==slow2) return slow;
        }
    }
}
