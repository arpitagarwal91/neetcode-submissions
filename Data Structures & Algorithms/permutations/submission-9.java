class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getAllPerms(0, nums, res);
        return res;
    }

    private void getAllPerms(int idx, int[] nums, List<List<Integer>> res){
        if(idx>=nums.length){
            List<Integer> ls = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(ls);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums, i, idx);
            getAllPerms(idx+1, nums, res); //did i+1 here instead if idx+1
            swap(nums, i, idx);
        }
    }

    private void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
