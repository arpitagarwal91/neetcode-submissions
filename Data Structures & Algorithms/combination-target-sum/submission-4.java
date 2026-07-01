class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> ls = new ArrayList();
        backtrack(0,nums,ls,res,target);
        return res;
    }

    public void backtrack(int i, int[] nums, List<Integer> ls, List<List<Integer>> res, int target){
        if(target<0||i>=nums.length) return;
        if(target==0){
            res.add(new ArrayList(ls));
            return;
        }
        ls.add(nums[i]);
        backtrack(i, nums, ls, res, target-nums[i]);
        ls.remove(ls.size()-1);
        backtrack(i+1, nums, ls, res, target);
    }
}
