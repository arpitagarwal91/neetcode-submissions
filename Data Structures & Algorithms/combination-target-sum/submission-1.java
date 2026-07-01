class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        backtrack(0, nums, target, list, res);
        return res;
    }

    public void backtrack(int i, int nums[], int target, List<Integer> list, List<List<Integer>> res){
        if(target == 0){
            List<Integer> ans = new ArrayList(list);
            res.add(ans);
            return;
        }
        if(target<0 || i>=nums.length) return;
        list.add(nums[i]);
        backtrack(i, nums, target-nums[i], list, res);
        list.remove(list.size()-1);
        backtrack(i+1, nums, target, list, res);
    }
    
}
