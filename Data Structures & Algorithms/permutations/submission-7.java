class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res);
        return res;
    }

    public void backtrack(int idx, int[] nums, List<List<Integer>> res){
        if(idx==nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num:nums) perm.add(num);
            res.add(perm);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums, idx, i);
            backtrack(idx+1, nums, res);
            swap(nums, idx, i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
