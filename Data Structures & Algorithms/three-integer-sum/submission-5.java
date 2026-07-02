class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    res.add(ls);
                    l++;
                    r--;
                }
                else if(nums[i]+nums[l]+nums[r]>0) r--;
                else l++;
            }
        }
        return new ArrayList(res);
    }
}
