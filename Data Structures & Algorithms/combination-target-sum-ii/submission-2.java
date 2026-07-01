class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet();
        List<Integer> list = new ArrayList();
        backtrack(0, candidates, target, list, res);
        return new ArrayList(res);
    }

    public void backtrack(int i, int candidates[], int target, List<Integer> list, Set<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList(list));
            return;
        }
        if(target<0 || i>=candidates.length) return;
        list.add(candidates[i]);
        backtrack(i+1, candidates, target-candidates[i], list, res);
        list.remove(list.size()-1);
        backtrack(i+1, candidates, target, list, res);
    }
}
