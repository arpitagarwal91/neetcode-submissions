class Solution {

    Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            List<Integer> ls = adj.get(prerequisites[i][0]);
            ls.add(prerequisites[i][1]);
            adj.put(prerequisites[i][0], ls);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i, numCourses, adj)) return false;
        }
        return true;
    }

    public boolean dfs(int i, int numCourses, Map<Integer,List<Integer>> adj){
        if(visit.contains(i)) return false;
        if(adj.get(i).size()==0) return true;
        visit.add(i);
        for(int j=0;j<adj.get(i).size();j++){
            if(!dfs(adj.get(i).get(j), numCourses, adj)) return false;
        }
        visit.remove(i);
        adj.put(i, new ArrayList());
        return true;
    }
}
