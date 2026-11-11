class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(points[j][0]-points[i][0]) + Math.abs(points[j][1]-points[i][1]);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{i, dist});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        Set<Integer> visit = new HashSet<>();
        pq.add(new int[]{0, 0});
        int cost = 0;
        while(visit.size()<n && !pq.isEmpty()){
            int src = pq.peek()[0];
            int d = pq.poll()[1];
            if(visit.contains(src)) continue;
            visit.add(src);
            cost += d;
            for(int nei[]:adj.getOrDefault(src, Collections.emptyList())){
                pq.add(nei);
            }
        }
        return cost;
    }
}
