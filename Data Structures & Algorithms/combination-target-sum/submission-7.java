class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        getCombSum(0, nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void getCombSum(int idx, int nums[], int curSum, int target, List<Integer> ls, List<List<Integer>> res){
        if(curSum>target) return;
        if(curSum==target){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(idx==nums.length) return;
        ls.add(nums[idx]);
        getCombSum(idx, nums, curSum+nums[idx], target, ls, res);
        ls.remove(ls.size()-1);
        getCombSum(idx+1, nums, curSum, target, ls, res);
    }
}
