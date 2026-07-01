class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet();
        List<Integer> ls = new ArrayList();
        Arrays.sort(candidates);
        backtrack(0,ls,res,candidates,target);
        return res.stream().toList();
    }

    public void backtrack(int i, List<Integer> ls, Set<List<Integer>> res, int[] candidates, int target){
        if(target==0){
            res.add(new ArrayList(ls));
            return;
        }
        if(i>=candidates.length || target<0) return;
        ls.add(candidates[i]);
        backtrack(i+1, ls, res, candidates, target-candidates[i]);
        ls.remove(ls.size()-1);
        backtrack(i+1, ls, res, candidates, target);
    }
}
