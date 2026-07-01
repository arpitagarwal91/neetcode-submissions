class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap();
        for(int time[] : times){
            List<int[]> ls = adj.getOrDefault(time[0], new ArrayList());
            ls.add(new int[]{time[1],time[2]});
            adj.put(time[0], ls);
        }
        Set<Integer> visit = new HashSet();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,k});
        int t=0;
        while(!pq.isEmpty()){
            int node[] = pq.poll();
            if(visit.contains(node[1])) continue;
            t = node[0];
            visit.add(node[1]);
            if(adj.containsKey(node[1])){
                for(int nei[]:adj.get(node[1])){
                    if(!visit.contains(nei[0])){
                        pq.add(new int[]{node[0]+nei[1],nei[0]});
                    }
                }
            }
        }
        return visit.size()==n?t:-1;
    }
}
