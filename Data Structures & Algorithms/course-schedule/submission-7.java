class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int pre[]:prerequisites) adjList.get(pre[0]).add(pre[1]);
        for(int i=0;i<numCourses;i++){
            if(!dfs(i, new HashSet<>(), adjList)) return false;
        }
        return true;
    }

    public boolean dfs(int i, Set<Integer> visit, Map<Integer, List<Integer>> adjList){
        if(visit.contains(i)) return false;
        visit.add(i);
        for(Integer k:adjList.get(i)){
            if(!dfs(k, visit, adjList)) return false;
        }
        visit.remove(i);
        adjList.put(i, new ArrayList<>());
        return true;
    }
}
