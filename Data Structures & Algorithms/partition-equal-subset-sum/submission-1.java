class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2==1) return false;
        Set<Integer> dp = new HashSet();
        dp.add(0);
        for(int num:nums){
            Set<Integer> nextDp = new HashSet();
            for(int n:dp){
                nextDp.add(n);
                nextDp.add(n+num);
            }
            dp = nextDp;
        }
        return dp.contains(sum/2);
    }
}
