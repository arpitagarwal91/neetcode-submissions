class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adjList.put(i, new HashSet<Integer>());
        }
        for(int preq[]:prerequisites){
            adjList.get(preq[0]).add(preq[1]);
        }
        Set<Integer> visit = new HashSet<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adjList,visit,numCourses)) return false;
        }
        return true;
    }

    public boolean dfs(int i, Map<Integer, Set<Integer>> adjList, Set<Integer> visit, int n){
        if(visit.contains(i)) return false;
        if(adjList.get(i).size()==0) return true;
        visit.add(i);
        for(int dest:adjList.get(i)){
            if(!dfs(dest,adjList,visit,n)) return false;
        }
        visit.remove(i);
        adjList.put(i, new HashSet<>());
        return true;
    }
}
