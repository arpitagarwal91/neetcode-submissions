class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap();
        for(int[] time: times){
            List<int[]> edge = edges.getOrDefault(time[0], new ArrayList());
            edge.add(new int[]{time[1], time[2]});
            edges.put(time[0], edge);
        }
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)-> a[0]-b[0]);
        Set<Integer> visit = new HashSet();
        q.add(new int[]{0,k});
        int t=0;
        while(q.size()>0){
            int ele[] = q.poll();
            if(visit.contains(ele[1])) continue;
            t = ele[0];
            visit.add(ele[1]);
            if(edges.containsKey(ele[1])){
                for(int[] nei:edges.get(ele[1])){
                    if(!visit.contains(nei[0])){
                        q.add(new int[]{ele[0]+nei[1], nei[0]});
                    }
                }
            }
        }
        return visit.size()==n ? t : -1;
    }
}
