public class Solution {
    public List<List<int>> Subsets(int[] nums) {
        List<List<int>> res = new();
        List<int> ls = new();
        backtrack(0, nums, res, ls);
        return res;
    }

    public void backtrack(int i, int []nums, List<List<int>> res, List<int> ls){
        if(i==nums.Length){
            res.Add(new List<int>(ls));
            return;
        }
        ls.Add(nums[i]);
        backtrack(i+1, nums, res, ls);
        ls.RemoveAt(ls.Count()-1);
        backtrack(i+1, nums, res, ls);
    }
}
