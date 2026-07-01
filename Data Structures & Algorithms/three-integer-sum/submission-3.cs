public class Solution {
    public List<List<int>> ThreeSum(int[] nums) {
        HashSet<List<int>> visit = new HashSet<List<int>>();
        Array.Sort(nums);
        for(int i=0;i<nums.Length-2;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            int l=i+1;
            int r=nums.Length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0) {
                    visit.Add(new List<int> {nums[i], nums[l], nums[r]});
                    l++;
                    r--;
                    while(l<r && nums[l-1]==nums[l]) l++;
                }
                if(nums[i]+nums[l]+nums[r]>0) r--;
                if(nums[i]+nums[l]+nums[r]<0) l++;
            }
        }
        return visit.ToList();
    }
}
