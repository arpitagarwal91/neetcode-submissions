class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l+1]==nums[l]) l++;
                    while(l<r && nums[r-1]==nums[r]) r--;
                    l++;
                    r--;
                }
                else if(sum<0) l++;
                else r--;
            }
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        }
        return res;
    }
}
