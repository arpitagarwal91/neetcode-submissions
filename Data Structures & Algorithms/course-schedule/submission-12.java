class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int pre[]:prerequisites){
            adj.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        boolean visit[] = new boolean[n];
        boolean cycle[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!dfs(i, adj, cycle, visit)) return false;
        }
        return true;
    }

    private boolean dfs(int idx, Map<Integer, List<Integer>> adj, boolean cycle[], boolean visit[]){
        if(cycle[idx]) return false;
        if(visit[idx]) return true;
        cycle[idx] = true;
        for(int child:adj.getOrDefault(idx, Collections.emptyList())){
            if(!dfs(child, adj, cycle, visit)) return false;
        }
        cycle[idx] = false;
        visit[idx] = true;
        return true;
    }
}
