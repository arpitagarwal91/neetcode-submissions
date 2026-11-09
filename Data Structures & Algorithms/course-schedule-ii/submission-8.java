class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        for(int pre[]:prerequisites) adj.get(pre[0]).add(pre[1]);
        boolean visit[] = new boolean[n];
        boolean cycle[] = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!dfs(i, adj, cycle, visit, res)) return new int[0];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int src, Map<Integer, List<Integer>> adj, boolean cycle[], boolean visit[], List<Integer> res){
        if(cycle[src]) return false;
        if(visit[src]) return true;
        cycle[src] = true;
        for(int nei:adj.get(src)){
            if(!dfs(nei, adj, cycle, visit, res)) return false;
        }
        cycle[src] = false;
        visit[src] = true;
        res.add(src);
        return true;
    }
}
