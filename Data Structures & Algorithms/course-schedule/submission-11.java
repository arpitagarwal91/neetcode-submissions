class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int pre[]:prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        //boolean visit[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!dfs(i, adj, new boolean[n])) return false;
        }
        return true;
    }

    private boolean dfs(int i, List<List<Integer>> adj, boolean visit[]){
        if(visit[i]) return false;
        visit[i] = true;
        for(int nei:adj.get(i)){
            if(!dfs(nei, adj, visit)) return false;
        }
        visit[i] = false;
        adj.set(i, new ArrayList<>());
        return true;
    }
}
