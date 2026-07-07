class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++) adj.put(i, new HashSet<>());
        for(int pre[]:prerequisites){
            Set<Integer> set1 = adj.get(pre[0]);
            set1.add(pre[1]);
            adj.put(pre[0],set1);
        }
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adj,visit,cycle,res)) return new int[0]; //Mistake #2 Tried returning res directly from here as well.
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(int i, Map<Integer, Set<Integer>> adj, Set<Integer> visit, Set<Integer> cycle, List<Integer> res){
        if(cycle.contains(i)) return false;
        if(visit.contains(i)) return true;
        cycle.add(i);
        for(int nei:adj.get(i)){
            if(!dfs(nei, adj, visit, cycle, res)) return false;
        }
        cycle.remove(i);
        visit.add(i); //Mistake #1 - Wrote this operation before cycle.add(i).
        res.add(i);
        return true;
    }
}
