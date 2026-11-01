class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(0, nums, res);
        return res;
    }

    private void permute(int idx, int[] nums, List<List<Integer>> res){
        if(idx==nums.length){
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums, i, idx);
            permute(idx+1, nums, res);
            swap(nums, i, idx);
        }
    }

    private void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
