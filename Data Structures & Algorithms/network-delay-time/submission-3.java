class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int time[]:times){
            adj.computeIfAbsent(time[0], y->new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        //visit.add(k); //Added this here instead adding after popping from pq
        pq.add(new int[]{k, 0});
        int t = 0;
        while(!pq.isEmpty()){
            int ele[] = pq.poll();
            if(visit.contains(ele[0]))continue;
            t = ele[1];
            visit.add(ele[0]);
            List<int[]> ls = adj.getOrDefault(ele[0], new ArrayList<>());
            for(int[] p:ls){
                if(!visit.contains(p[0])){
                    pq.add(new int[]{p[0], ele[1]+p[1]});
                }
            }
        }
        return visit.size()==n ? t : -1;
    }
}
