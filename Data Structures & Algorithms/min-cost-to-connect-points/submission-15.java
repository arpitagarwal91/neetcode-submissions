class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{i, dist});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visit = new HashSet<>();
        pq.add(new int[]{0, 0}); //point, dist
        int cost = 0;
        while(visit.size()<n && !pq.isEmpty()){
            int ele[] = pq.poll();
            if(visit.contains(ele[0])) continue;
            visit.add(ele[0]);
            cost+=ele[1];
            for(int nei[]:adj.getOrDefault(ele[0], Collections.emptyList())){
                pq.add(nei);
            }
        }
        return cost;
    }
}
