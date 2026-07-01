class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap();
        for(int i=0;i<points.length;i++){
            int a[] = points[i];
            List<int[]> destA = adj.getOrDefault(i, new ArrayList());
            for(int j=i+1;j<points.length;j++){
                int b[] = points[j];
                List<int[]> destB = adj.getOrDefault(j, new ArrayList());
                int dist = Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
                destA.add(new int[]{j, dist});
                destB.add(new int[]{i, dist});
                adj.put(i, destA);
                adj.put(j, destB);
            }
        }

        int cost = 0;
        Set<Integer> visit = new HashSet();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{0,0});
        while(visit.size()<points.length && pq.size()>0){
            int ele[] = pq.poll();
            if(visit.contains(ele[1])) continue;
            visit.add(ele[1]);
            cost+=ele[0];
            for(int nei[]:adj.getOrDefault(ele[1], Collections.emptyList())){
                if(!visit.contains(nei[0])){
                    pq.add(new int[]{nei[1], nei[0]});
                }
            }
        }
        return cost;
    }
}
