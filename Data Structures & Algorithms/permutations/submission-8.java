class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res);
        return res;
    }

    private void dfs(int idx, int[] nums, List<List<Integer>> res){
        if(idx==nums.length) {
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ls.add(nums[i]);
            }
            res.add(ls);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums, idx, i);
            dfs(idx+1, nums, res);
            swap(nums, idx, i);
        }
    }

    private void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    } 
}
