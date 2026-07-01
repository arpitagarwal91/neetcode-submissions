public class Solution {
    public bool hasDuplicate(int[] nums) {
        var visit = new HashSet<int>();
        for(int i=0;i<nums.Count();i++){
            if(visit.Contains(nums[i])) return true;
            visit.Add(nums[i]);
        }
        return false;
    }
}