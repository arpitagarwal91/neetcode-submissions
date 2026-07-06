class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }

    public void backtrack(int i, int[] nums, List<Integer> ls, List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[i]);
        backtrack(i+1, nums, ls, res);
        ls.remove(ls.size()-1);
        backtrack(i+1, nums, ls, res);
    }
}
