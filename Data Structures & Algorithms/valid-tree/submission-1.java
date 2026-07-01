class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visit = new HashSet();
        Map<Integer, Set<Integer>> adj = new HashMap();
        for(int i=0;i<n;i++) adj.put(i, new HashSet());
        for(int edge[]:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0,-1,visit,adj) && visit.size()==n;
    }

    public boolean dfs(int k, int prev, Set<Integer> visit, Map<Integer, Set<Integer>> adj){
        if(visit.contains(k)) return false;
        visit.add(k);
        for(int p:adj.get(k)){
            if(p==prev) continue;
            if(!dfs(p,k,visit,adj)) return false;
        }
        return true;
    }
}
