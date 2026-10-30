class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        boolean visit[] = new boolean[n];
        boolean cycle[] = new boolean[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        for(int pre[]:prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!dfs(i, adj, visit, cycle, res)) return new int[0];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit, boolean[] cycle, List<Integer> res){
        if(cycle[node]) return false;
        if(visit[node]) return true;
        cycle[node] = true;
        for(int nei:adj.get(node)){
            if(!dfs(nei, adj, visit, cycle, res)) return false;
        }
        cycle[node] = false;
        visit[node] = true;
        res.add(node);
        return true;
    }
}
