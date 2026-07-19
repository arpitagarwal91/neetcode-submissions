class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        backtrack(0,nums,res);
        return new ArrayList(res);
    }

    public void backtrack(int fixIdx, int[] nums, Set<List<Integer>> res){
        if(fixIdx==nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num:nums) perm.add(num);
            res.add(perm);
        }
        for(int i=fixIdx;i<nums.length;i++){
            swap(nums, fixIdx, i);
            backtrack(fixIdx+1, nums, res);
            swap(nums, fixIdx, i);
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}