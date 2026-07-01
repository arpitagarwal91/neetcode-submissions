public class Solution {
    public List<List<int>> CombinationSum(int[] nums, int target) {
        List<List<int>> res = new List<List<int>>();
        List<int> ls = new List<int>();
        backtrack(0, ls, res, nums, target);
        return res;
    }

    public void backtrack(int i, List<int> ls, List<List<int>> res, int[] nums, int target){
        if(target<0 || i>=nums.Length) return;
        if(target==0){
            res.Add(new List<int>(ls));
            return;
        }
        ls.Add(nums[i]);
        backtrack(i, ls, res, nums, target-nums[i]);
        ls.RemoveAt(ls.Count()-1);
        backtrack(i+1, ls, res, nums, target);
    }
}
