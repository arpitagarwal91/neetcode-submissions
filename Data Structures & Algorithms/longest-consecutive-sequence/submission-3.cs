public class Solution {
    public int LongestConsecutive(int[] nums) {
        if(nums.Length==0) return 0;
        int res = 1;
        var visit = new HashSet<int>();
        foreach(int num in nums) visit.Add(num);
        for(int i=0;i<nums.Length;i++){
            int seq = 1;
            if(!visit.Contains(nums[i]-1)){
                while(visit.Contains(nums[i]+1)){
                    seq++;
                    nums[i]++;
                }
            }
            res = Math.Max(res, seq);
            if(res>nums.Length/2) break;
        }
        return res;
    }
}
