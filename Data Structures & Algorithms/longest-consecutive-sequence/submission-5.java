class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visit = new HashSet<>();
        for(int num:nums) visit.add(num);
        int res = 0;
        for(int num:nums){
            if(!visit.contains(num-1)){
                int start = num;
                int k = 0;
                while(visit.contains(start+k)){
                    k++;
                    res = Math.max(res, k);
                }
            }
        }
        return res;
    }
}
