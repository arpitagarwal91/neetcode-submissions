class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> adjList = new HashMap();
        Set<Integer> visit = new HashSet();
        for(int i=0;i<numCourses;i++){
            adjList.put(i, new HashSet());
        }
        for(int pre[]:prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, adjList, visit)) return false;
        }
        return true;
    }

    public boolean dfs(int i, Map<Integer,Set<Integer>> adjList, Set<Integer> visit){
        if(visit.contains(i)) return false;
        if(adjList.get(i).size()==0) return true;
        visit.add(i);
        for(Integer k:adjList.get(i)){
            if(!dfs(k, adjList, visit)){
                return false;
            }
        }
        visit.remove(i);
        adjList.put(i, new HashSet());
        return true;
    }
}
