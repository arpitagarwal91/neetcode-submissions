class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int idx, int[] candidates, int curSum, int target, List<Integer> ls, List<List<Integer>> res){
        //if(curSum>target) return;
        if(curSum==target){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(curSum+candidates[i]>target) break;
            ls.add(candidates[i]);
            backtrack(i+1, candidates, curSum+candidates[i], target, ls, res);
            ls.remove(ls.size()-1);
        }
    }
}
