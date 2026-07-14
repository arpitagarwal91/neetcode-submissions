class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int n:nums){
            List<List<Integer>> newPerms = new ArrayList<>();
            for(List<Integer> p:res){
                for(int i=0;i<p.size()+1;i++){
                    List<Integer> copy = new ArrayList<>(p);
                    copy.add(i, n);
                    newPerms.add(copy);
                }
            }
            res = newPerms;
        }
        return res;
    }
}
