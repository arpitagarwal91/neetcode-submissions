class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0;i<points.length-1;i++){
            int[] pointA = points[i];
            for(int j=i+1;j<points.length;j++){
                int[] pointB = points[j];
                int dist = Math.abs(pointA[0]-pointB[0]) + Math.abs(pointA[1]-pointB[1]);
                adj.computeIfAbsent(i, k-> new ArrayList<>()).add(new int[]{j, dist});
                adj.computeIfAbsent(j, k-> new ArrayList<>()).add(new int[]{i, dist});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        Set<Integer> visit = new HashSet<>();
        pq.add(new int[]{0,0});
        int total = 0;
        while(!pq.isEmpty()){
            int ele[] = pq.poll();
            int p1 = ele[0];
            if(visit.contains(p1)) continue;
            visit.add(p1);
            total+=ele[1];
            if(visit.size()==points.length) return total;
            for(int dest[]:adj.get(p1)){
                pq.add(dest);
            }
        }
        return -1;
    }
}
