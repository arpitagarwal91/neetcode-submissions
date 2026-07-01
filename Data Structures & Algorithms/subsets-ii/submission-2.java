class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet();
        List<Integer> ls = new ArrayList();
        backtrack(0,nums,ls,res);
        return res.stream().toList();
    }

    public void backtrack(int i, int[] nums, List<Integer> ls, Set<List<Integer>> res){
        if(i>nums.length) return;
        if(i==nums.length){
            res.add(new ArrayList(ls));
            return;
        }
        ls.add(nums[i]);
        backtrack(i+1, nums, ls, res);
        ls.remove(ls.size()-1);
        backtrack(i+1, nums, ls, res);
    }
}
