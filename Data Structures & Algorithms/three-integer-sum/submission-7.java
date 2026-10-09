class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> ls = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(ls);
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(r>l && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if(nums[i]+nums[l]+nums[r]<0){
                    l++;
                }
                else r--;
                while(i+1<nums.length && nums[i]==nums[i+1]) i++;
            }
        }
        return res;
    }
}
