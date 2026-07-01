class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;
        Set<Integer> dp = new HashSet();
        dp.add(0);
        for(int num:nums){
            Set<Integer> nextDp = new HashSet();
            for(int t:dp){
                nextDp.add(t);
                nextDp.add(num+t);
            }
            dp = nextDp;
        }
        return dp.contains(target);
    }
}
