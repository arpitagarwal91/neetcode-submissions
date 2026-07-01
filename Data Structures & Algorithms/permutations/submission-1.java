class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums.length==0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        List<List<Integer>> perms = 
        permute(Arrays.copyOfRange(nums,1,nums.length));
        
        for(List<Integer> perm:perms){
            for(int i=0;i<perm.size()+1;i++){
                List<Integer> pcopy = new ArrayList(perm);
                pcopy.add(i, nums[0]);
                res.add(pcopy);
            }
        }
        return res;
    }
}