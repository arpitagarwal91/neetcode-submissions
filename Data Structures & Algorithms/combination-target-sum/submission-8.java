class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int idx, int[] nums, int target, List<Integer> ls, List<List<Integer>> res){
        if(idx==nums.length){
            if(target==0) res.add(new ArrayList<>(ls));
            return;
        }
        if(target<0) return;
        
        ls.add(nums[idx]);
        backtrack(idx, nums, target-nums[idx], ls, res);
        ls.remove(ls.size()-1);
        backtrack(idx+1, nums, target, ls, res);

    }
}
