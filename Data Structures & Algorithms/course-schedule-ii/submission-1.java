class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> adjList = new HashMap();
        Set<Integer> visit = new HashSet();
        Set<Integer> cycle = new HashSet();
        List<Integer> res = new ArrayList();
        for(int i=0;i<numCourses;i++){
            adjList.put(i, new HashSet());
        }
        for(int pre[]:prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adjList,visit,cycle,res)) return new int[0];
        }
        int output[] = new int[res.size()];
        for(int i=0;i<res.size();i++) output[i] = res.get(i);
        return output;
    }

    public boolean dfs(int i, Map<Integer,Set<Integer>> adjList, Set<Integer> visit, Set<Integer> cycle, List<Integer> res){
        if(cycle.contains(i)) return false;
        if(visit.contains(i)) return true;
        cycle.add(i);
        for(int k:adjList.get(i)){
            if(!dfs(k, adjList, visit, cycle, res)) return false;
        }
        cycle.remove(i);
        visit.add(i);
        res.add(i);
        return true;
    }
}
