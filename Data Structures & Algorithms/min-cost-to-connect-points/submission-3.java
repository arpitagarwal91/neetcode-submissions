class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer,List<int[]>> adj = new HashMap();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                List<int[]> lsi = adj.getOrDefault(i, new ArrayList());
                List<int[]> lsj = adj.getOrDefault(j, new ArrayList());
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                lsi.add(new int[]{j,dist});
                lsj.add(new int[]{i,dist});
                adj.put(i,lsi);
                adj.put(j,lsj);
            }
        }
        int t=0;
        Set<Integer> visit = new HashSet();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,0});
        while(visit.size()<points.length){
            int ele[] = pq.poll();
            if(visit.contains(ele[1])) continue;
            t+=ele[0];
            visit.add(ele[1]);
            for(int nei[]:adj.getOrDefault(ele[1], Collections.emptyList())){
                if(!visit.contains(nei[0])){
                    pq.add(new int[]{nei[1], nei[0]});
                }
            }
        }
        return t;
    }
}
