class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res.stream().collect(Collectors.toList());
    }

    private void backtrack(int idx, int[] candidates, int target, List<Integer> ls, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(target-candidates[i]<0) break;
            ls.add(candidates[i]);
            backtrack(i+1, candidates, target-candidates[i], ls, res);
            ls.remove(ls.size()-1);
        }
    }
}
