class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new HashSet<>());
        for(int edge[]:edges){
            adj.computeIfAbsent(edge[0], k->new HashSet<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k->new HashSet<>()).add(edge[0]);
        }
        Set<Integer> visit = new HashSet<>();
        return dfs(0, -1, adj, visit) && visit.size()==n;
    }

    public boolean dfs(int i, int prev, Map<Integer, Set<Integer>> adj, Set<Integer> visit){
        if(visit.contains(i)) return false;
        visit.add(i);
        for(int nei:adj.get(i)){
            if(prev==nei) continue; //Forgot the importance of this line and some more problems in writing correct dfs.
            if(!dfs(nei, i, adj, visit)) return false;
        }
        return true;
    }
}
