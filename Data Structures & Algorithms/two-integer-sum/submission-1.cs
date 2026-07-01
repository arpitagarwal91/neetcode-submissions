public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var visit = new Dictionary<int, int>();
        for(int i=0;i<nums.Count();i++){
            if(visit.TryGetValue(target - nums[i], out int val)){
                return new int[]{val, i};
            }
            visit[nums[i]] = i;
        }
        return new int[]{-1, -1};
    }
}
