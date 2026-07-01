class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());

        for(int n:nums){
            List<List<Integer>> perms = new ArrayList();
            for(List<Integer> p:res){
                for(int i=0;i<p.size()+1;i++){
                    List<Integer> pcopy = new ArrayList(p);
                    pcopy.add(i,n);
                    perms.add(pcopy);
                }
            }
            res = perms;
        }
        return res;
    }
}
