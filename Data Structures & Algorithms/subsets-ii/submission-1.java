class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet();
        List<Integer> ls = new ArrayList();
        dfs(0, nums, ls, res);
        return new ArrayList(res);
    }

    public void dfs(int i, int[] nums, List<Integer> ls, Set<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList(ls));
            return;
        }
        ls.add(nums[i]);
        dfs(i+1, nums, ls, res);
        ls.remove(ls.size()-1);
        dfs(i+1, nums, ls, res);
    }

    
}
