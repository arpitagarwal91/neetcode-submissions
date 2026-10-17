class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean visit[] = new boolean[n];
        boolean cycle[] = new boolean[n];
        for(int pre[]:prerequisites){
            adj.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!visit[i]){
                if(!dfs(i, adj, visit, cycle, res)) return new int[0];
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int idx, Map<Integer, List<Integer>> adj, boolean visit[], boolean cycle[], List<Integer> res){
        if(cycle[idx]) return false;
        if(visit[idx]) return true;
        cycle[idx] = true;
        for(int nei:adj.getOrDefault(idx, Collections.emptyList())){
            if(!dfs(nei, adj, visit, cycle, res)) return false;
        }
        cycle[idx] = false;
        visit[idx] = true;
        res.add(idx);
        return true;
    }
}

