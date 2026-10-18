class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> visit = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int res = 0;
        for(int num:nums){
            if(!visit.contains(num-1)){
                int k = 0;
                while(visit.contains(num+k)) k++;
                res = Math.max(res, k);
            }
        }
        return res;
    }
}
