class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    public void backtrack(int nums[], int i, List<List<Integer>> res){
        if(i == nums.length){
            List<Integer> perm = new ArrayList();
            for(int n:nums) perm.add(n);
            res.add(perm);
            return;
        }
        for(int k=i;k<nums.length;k++){
            swap(nums, i, k);
            backtrack(nums, i+1, res);
            swap(nums, i, k);
        }
    }

    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
