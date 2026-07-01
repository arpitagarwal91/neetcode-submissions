class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        backtrack(0, nums, list, res);
        return res;
    }

    public void backtrack(int i, int nums[], List<Integer> list, List<List<Integer>> res){
        if(i==nums.length){
            List<Integer> ans = new ArrayList(list);
            res.add(ans);
            return;
        }
        list.add(nums[i]);
        backtrack(i+1, nums, list, res);
        list.remove(list.size()-1);
        backtrack(i+1, nums, list, res);
    }
}
