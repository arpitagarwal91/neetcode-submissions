class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    public void backtrack(int i, int[] nums, int curSum, int target, List<Integer> ls, List<List<Integer>> res){
        if(curSum==target){
            res.add(new ArrayList(ls));
            return;
        }
        if(i==nums.length ||curSum>target) return;
        ls.add(nums[i]);
        backtrack(i, nums, curSum+nums[i], target, ls, res);
        ls.remove(ls.size()-1);
        backtrack(i+1, nums, curSum, target, ls, res);
    }
}
