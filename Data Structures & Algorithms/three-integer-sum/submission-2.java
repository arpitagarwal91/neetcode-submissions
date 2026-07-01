class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length - 1;
            while(start<end){
                if(nums[i]+nums[start]+nums[end] == 0){
                    List<Integer> sol = new ArrayList();
                    sol.add(nums[i]);
                    sol.add(nums[start]);
                    sol.add(nums[end]);
                    res.add(sol);
                    start++;
                }
                if(nums[i]+nums[start]+nums[end] < 0) start++;
                if(nums[i]+nums[start]+nums[end] > 0) end--;
            }
        }
        return new ArrayList(res);
    }
}
