class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap();
        Set<Integer> visit = new HashSet();
        for(int i=0;i<n;i++){
            adj.put(i, new ArrayList());
        }
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0,-1,visit,adj) && visit.size()==n;
    }

    public boolean dfs(int i, int prev, Set<Integer> visit, Map<Integer, List<Integer>> adj){
        if(visit.contains(i)) return false;
        visit.add(i);
        for(int j:adj.get(i)){
            if(j==prev) continue;
            if(!dfs(j, i, visit, adj)) return false;
        }
        return true;
    }
}
