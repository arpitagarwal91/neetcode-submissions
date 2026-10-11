class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        boolean visit[] = new boolean[n];
        boolean cycle[] = new boolean[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int pre[]:prerequisites){
            adj.computeIfAbsent(pre[0], k->new HashSet<>()).add(pre[1]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!dfs(i, adj, cycle, visit, res)) return new int[0];
        }
        int ans[] = new int[res.size()];
        int k = 0;
        for(int val:res) ans[k++] = val;
        return ans;
    }

    private boolean dfs(int idx, Map<Integer, Set<Integer>> adj, boolean cycle[], boolean visit[], List<Integer> res){
        if(cycle[idx]) return false;
        if(visit[idx]) return true;
        cycle[idx] = true;
        for(int nei:adj.getOrDefault(idx, new HashSet<>())){
            if(!dfs(nei, adj, cycle, visit, res)) return false;
        }
        cycle[idx] = false;
        visit[idx] = true;
        res.add(idx);
        //adj.put(idx, new HashSet<>());
        return true;
    }
}
