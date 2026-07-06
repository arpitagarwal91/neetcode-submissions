class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visit = new HashSet<>();
        int res = 0;
        for(int num:nums) visit.add(num);
        for(int num:nums){
            if(!visit.contains(num-1)){
                int start = num;
                while(visit.contains(start)){
                    res = Math.max(res, start-num+1);
                    start++;
                }
            }
        }
        return res;
    }
}
