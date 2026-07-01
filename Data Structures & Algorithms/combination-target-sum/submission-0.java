class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(nums, 0, arr, result, target);
        return result;
    }

    public void backtrack(int[] nums, int i, List<Integer> arr, List<List<Integer>> result, int target){
        if(target == 0){
            result.add(new ArrayList<>(arr));
            return;
        }
        if(i>= nums.length || target < 0){
            return;
        }
        arr.add(nums[i]);
        backtrack(nums, i, arr, result, target-nums[i]);
        arr.remove(arr.size()-1);
        backtrack(nums, i+1, arr, result, target);
    }
}
