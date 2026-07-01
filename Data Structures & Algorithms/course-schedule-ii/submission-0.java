class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap();
        for(int i=0;i<numCourses;i++) mp.put(i,new ArrayList<Integer>());
        Set<Integer> visit = new HashSet();
        Set<Integer> cycle = new HashSet();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<prerequisites.length;i++) mp.get(prerequisites[i][0]).add(prerequisites[i][1]);
        for(int i=0;i<numCourses;i++) if(!dfs(i, mp, visit, cycle, ans)) return new int[0];
        int res[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++) res[i] = ans.get(i);
        return res;
    }

    public boolean dfs(int i, Map<Integer, List<Integer>> mp, Set<Integer> visit, Set<Integer> cycle, List<Integer> ans){
        if(cycle.contains(i)) return false;
        if(visit.contains(i)) return true;
        cycle.add(i);
        for(int k=0;k<mp.get(i).size();k++){
            if(!dfs(mp.get(i).get(k), mp, visit, cycle, ans)){
                return false;
            }
        }
        cycle.remove(i);
        visit.add(i);
        ans.add(i);
        return true;
    }
}
