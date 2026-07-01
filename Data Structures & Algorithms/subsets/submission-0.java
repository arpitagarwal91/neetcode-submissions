class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(nums, 0, arr, result);
        return result;
    }

    public void backtrack(int[] nums, int i, List<Integer> arr, List<List<Integer>> result){
        if(i >= nums.length){
            result.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        backtrack(nums, i+1, arr, result);
        arr.remove(arr.size()-1);
        backtrack(nums, i+1, arr, result);
    }
}
