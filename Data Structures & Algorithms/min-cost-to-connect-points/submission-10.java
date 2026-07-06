class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adjList.computeIfAbsent(i, k->new ArrayList<>()).add(new int[]{j, dist});
                adjList.computeIfAbsent(j, k->new ArrayList<>()).add(new int[]{i, dist});
            }
        }

        //Prim's
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});
        Set<Integer> visit = new HashSet<>();
        int cost = 0;
        while(visit.size()<points.length){
            int ele[] = pq.poll();
            if(visit.contains(ele[1])) continue;
            visit.add(ele[1]);
            cost += ele[0];
            for(int nei[]:adjList.getOrDefault(ele[1], Collections.emptyList())){
                if(!visit.contains(nei[0])){
                    pq.add(new int[]{nei[1], nei[0]});
                }
            }
        }
        return cost;
    }
}
