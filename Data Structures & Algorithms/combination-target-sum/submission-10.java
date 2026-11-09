class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res, target);
        return res;
    }

    private void backtrack(int idx, int[] nums, List<Integer> ls, List<List<Integer>> res, int target){
        if(target<0) return;
        if(idx==nums.length){
            if(target==0) res.add(new ArrayList<>(ls));
            return;
        }
        
        ls.add(nums[idx]);
        backtrack(idx, nums, ls, res, target-nums[idx]);
        ls.remove(ls.size()-1);

        backtrack(idx+1, nums, ls, res, target);
    }
}
