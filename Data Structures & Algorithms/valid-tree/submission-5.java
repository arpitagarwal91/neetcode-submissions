class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visit = new HashSet<>();
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n;i++) adjList.put(i, new ArrayList<>());
        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return dfs(0,-1,visit,adjList) && visit.size()==n;
    }

    public boolean dfs(int i, int prev, Set<Integer> visit, Map<Integer,List<Integer>> adjList){
        if(visit.contains(i)) return false;
        visit.add(i);
        for(int des:adjList.get(i)){
            if(des==prev) continue;
            if(!dfs(des, i, visit, adjList)) return false;
        }
        return true;
    }
}
